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


    private final List<Character> expression;

    public Calculadora(List<Character> expression) {
        this.expression = expression;
    }

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


