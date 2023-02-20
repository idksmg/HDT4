import java.util.ArrayList;
import java.util.*;
import java.util.Stack;
import java.util.List;
public class Calculadora<T> implements IPosfixCalculator<T> {


    public List<Character> infixToPostfix(List<Character> infix) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);

        List<Character> postfix = new ArrayList<>();
        Deque<Character> operatorStack = new ArrayDeque<>();

        for (int i = 0; i < infix.size(); i++) {
            char c = infix.get(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.add(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.add(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    throw new IllegalArgumentException("Expresion invalida");
                } else {
                    operatorStack.pop();
                }
            } else {
                while (!operatorStack.isEmpty() && precedence.get(c) <= precedence.get(operatorStack.peek())) {
                    if (operatorStack.peek() == '(') {
                        throw new IllegalArgumentException("Expresion invalida");
                    }
                    postfix.add(operatorStack.pop());
                }
                operatorStack.push(c);
            }

        }
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
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


