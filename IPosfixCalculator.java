import java.util.ArrayList;
import java.util.*;
public interface IPosfixCalculator<T> {

    /**
     * Método para convertir expresiones infix a postfix
     * @param infix
     * @return
     */
    public List<Character> infixToPostfix(ArrayList<Character> infix);

    /**
     * Método para calcular la expresion postfix si es un Array o Vector
     * @param postfix_expression
     * @return
     */
    public int Calculate(java.util.ArrayList<Character> postfix_expression);

    /**
     * Método para calcular la expresion postfix si es una Lista
     * @param arraylist
     * @return
     */
    public int CalculateList(ArrayList<Character> arraylist);
}
