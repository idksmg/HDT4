import java.util.ArrayList;
import java.util.*;
import java.util.Stack;
import java.util.List;
public class Calculadora<T> implements IPosfixCalculator<T>{


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
            }else if(c =='('){
                operatorStack.push(c);
            } else if (c ==')') {
                while(!operatorStack.isEmpty() && operatorStack.peek() !='('){
                    postfix.add(operatorStack.pop());
                }
                if(!operatorStack.isEmpty() &&operatorStack.peek() !='('){
                    throw new IllegalArgumentException("Expresion invalida");
                }else{
                    operatorStack.pop();
                }
            }else{
                while(!operatorStack.isEmpty() && precedence.get(c) <= precedence.get(operatorStack.peek())){
                    if(operatorStack.peek() == '('){
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
    public int Calculate(ArrayList<Character> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char token : postfix) {
            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
            } else if (token == '+' || token == '-' || token == '*' || token == '/' ) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case '+':
                        stack.push(operand1+operand2);
                        break;
                    case '-':
                        stack.push(operand1-operand2);
                        break;
                    case '*':
                        stack.push(operand1*operand2);
                        break;
                    case '/':
                        stack.push(operand1/operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private static class Node {
        private final char value;
        private Node next;

        public Node(char value) {
            this.value = value;
            this.next = null;
        }
    }


    private final List<Character> expression;
    private Node head;

    public Calculadora(List<Character> expression){
        this.expression=expression;
    }

    public int CalculateList(){
        buildList();
        Node node = head;
        while (node != null){
            char value = node.value;
            if(Character.isDigit(value)){
                stack.push(Character.getNumericValue(value));
            }else {
                int operando2 = stack.pop();
                int operando1 = stack.pop();
                int resultado = applyOperator(value, operando1, operando2);
                stack.push(resultado);
            }
            node = node.next;
        }
        return stack.pop();
    }
    private void buildList(){
        Node prev = null;
        for(int i= expression.size()-1; i>=0; i++){
            char value = expression.get(i);
            Node node = new Node(value);
            node.next = prev;
            prev = node;
        }
        head = prev;
    }

    private int applyOperator(char operator, int operando1, int operando2){
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
                throw new IllegalArgumentException("Operando desconocido" + operator);
        }
    }

    private final Stack<Integer> stack = new Stack<>();

}

