import java.util.ArrayList;
import java.util.*;
public interface IPosfixCalculator<T> {

    public List<Character> infixToPostfix(List<Character> infix);
    public int Calculate(java.util.ArrayList<T> postfix_expression) throws Exception;
}
