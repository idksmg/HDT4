import java.util.ArrayList;
public class StackArrayList<E> extends AbstractStack<E> {

    protected ArrayList<E> data;

    public StackArrayList(){
        data = new ArrayList<E>();
    }

    /**
     * Método de la interfaz Stack
     * @param item
     */
    public void push(E item){
        data.add(item);
    }

    /**
     * Método de la interfaz Stack
     * @return
     */
    public E pop(){
        return data.remove(size()-1);
    }

    /**
     * Método de la interfaz Stack
     * @return
     */
    public E peek(){
        return data.get(size()-1);
    }

    /**
     * Método de la interfaz Stack
     * @return
     */
    public int size(){
        return data.size();
    }
}
