import java.util.Vector;
public class StackVector<E> extends AbstractStack<E> {

    protected Vector<E> data;

    public StackVector(){
        data = new Vector<E>();
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
     * @return size-1
     */
    public E pop(){
       return data.remove((size()-1));
    }

    /**
     * Método de la interfaz Stack
     * @return size-1
     */

    public E peek(){
        return data.get(size()-1);
    }

    /**
     * Método de la interfaz Stack
     * @return size
     */
    public int size(){
        return data.size();
    }
}
