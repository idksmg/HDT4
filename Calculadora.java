import java.util.ArrayList;
import java.util.*;
import java.util.Stack;
import java.util.List;
public class Calculadora<T> implements IPosfixCalculator<T> {

    /**
     * Este método convierte expresiones Infix a Postfix
     * @param infix
     * @return un Array de tipo Character con la expresión postfix
     */
    public List<Character> infixToPostfix(ArrayList<Character> infix) {
        List<Character> postfix = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : infix) {
            if (Character.isLetterOrDigit(c)) {
                postfix.add(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("Invalid infix expression");
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid infix expression");
            }
            postfix.add(stack.pop());
        }

        return postfix;
    }

    /**
     * Este método privado sirve para la conversion de infix a postfix, establece el dato numerico de los caracteres dependiendo de cuales sean
     * @param c
     * @return Indice numerico dependiendo del tipo de caracter.
     */
    private static int precedence(Character c) {
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }


    /**
     * Este método realiza el calculo de la expresion ya convertida a postfix en el caso de que se elija de tipo Array o Vector.
     * @param postfix
     * @return resultado numerico
     */
    @Override
    public int Calculate(ArrayList<Character> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char token : postfix) {
            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
            } else if (token == '+' || token == '-' || token == '*' || token == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    /**
     * Este método calcula la expresion ya convertida a postfix si se elije una lista ya sea encadenada o doble encadenada.
     * @param arraypostfix
     * @return resultado numerico
     */
    public int CalculateList(ArrayList<Character> arraypostfix){
        Stack<Integer> stack = new Stack<>();
        for(Character token : arraypostfix){
            if(Character.isDigit(token)){
                stack.push(Character.getNumericValue(token));
            }else {
                int operando2 = stack.pop();
                int operando1 = stack.pop();
                stack.push(applyOperator(token, operando1, operando2));
            }
        }
        return stack.pop();
    }

    /**
     * Este método privado sirve para el calculo de la expresion con listas.
     * @param operator
     * @param operando1
     * @param operando2
     * @return la operacion a realizar con los operandos dependiendo de el caracter.
     */
    private int applyOperator(Character operator, int operando1, int operando2){
        switch (operator){
            case '+':
                return operando1+operando2;
            case '-':
                return operando1-operando2;
            case '*':
                return operando1*operando2;
            case '/':
                return operando1/operando2;
            default:
                throw new IllegalArgumentException("Expresion desconocida");
        }
    }
}


