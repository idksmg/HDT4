import java.util.ArrayList;
import java.util.*;
import java.util.Stack;
public class Calculadora<T> implements IPosfixCalculator<T>{

    private Stack<Integer> pila;
    public List<Character> infixToPostfix(List<Character> infix){
        Map<Character, Integer>precedence = new HashMap<>();
        precedence.put('^',3);
        precedence.put('*',2);
        precedence.put('/',2);
        precedence.put('+',1);
        precedence.put('-',1);

        List<Character> postfix = new ArrayList<>();
        Deque<Character> operatorStack = new ArrayDeque<>();

        for(int i =0; i<infix.size();i++){
            char c = infix.get(i);
            if(Character.isLetterOrDigit(c)){
                postfix.add(c);
            }else if(c=='('){
                operatorStack.push(c);
            } else if (c==')') {
                while(!operatorStack.isEmpty()&&operatorStack.peek()!='('){
                    postfix.add(operatorStack.pop());
                }
                if(!operatorStack.isEmpty()&&operatorStack.peek()!='('){
                    throw new IllegalArgumentException("Expresion invalida");
                }else{
                    operatorStack.pop();
                }
            }else{
                while(!operatorStack.isEmpty()&&precedence.get(c)<=precedence.get(operatorStack.peek())){
                    if(operatorStack.peek()=='('){
                        throw new IllegalArgumentException("Expresion invalida");
                    }
                    postfix.add(operatorStack.pop());
                }
                operatorStack.push(c);
            }

        }
        while(!operatorStack.isEmpty()){
            if(operatorStack.peek()=='('){
                throw new IllegalArgumentException("Expresion invalida");
            }
            postfix.add(operatorStack.pop());
        }
        return postfix;
    }
    @Override
    public int Calculate(ArrayList<T> postfix_expression) throws Exception {
        Integer resultadoFinal = 0;
        for (int i = 0; i<postfix_expression.size(); i++){

            Character[] charArray = postfix_expression.toArray(new Character[postfix_expression.size()]);

            if(charArray.length < 5){
                throw new Exception("Valores insuficientes para realizar la operacion.");
            }

            pila = new Stack<Integer>();
            for (int j = 0; j<charArray.length; j++){

                if(charArray[j] == '+'){

                    Integer operandoB = pila.pop();
                    Integer operandoA = pila.pop();
                    Integer resultadoDeSuma = operandoA+operandoB;
                    System.out.println("El resultado de la suma es " + resultadoDeSuma);
                    pila.push(resultadoDeSuma);
                }
                else if(charArray[j] == '-'){
                    if(pila.size() < 2){
                        throw new Exception("Valores insuficientes para realizar la operacion.");
                    }
                    Integer operandoB = pila.pop();
                    Integer operandoA = pila.pop();
                    Integer resultadoDeResta = operandoA-operandoB;
                    System.out.println("El resultado de la resta es " + resultadoDeResta);
                    pila.push(resultadoDeResta);
                }
                else if(charArray[j] == '*'){
                    if(pila.size() < 2){
                        throw new Exception("Valores insuficientes para realizar la operacion.");
                    }
                    Integer operandoB = pila.pop();
                    Integer operandoA = pila.pop();
                    pila.push(operandoA*operandoB);
                    Integer resultadoDeMultiplicacion = operandoA*operandoB;
                    System.out.println("El resultado de la multiplicacion es " + resultadoDeMultiplicacion);
                    pila.push(resultadoDeMultiplicacion);
                }

            }
            resultadoFinal = pila.pop();
            System.out.println("El resultado de la operacion completa es  " + resultadoFinal);

        }
        return resultadoFinal;
    }
}
