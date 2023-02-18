import java.util.ArrayList;
public class StackArrayList<E> extends AbstractStack<E> {

    protected ArrayList<E> data;

    public StackArrayList(){
        data = new ArrayList<E>();
    }

    public void push(E item){
        data.add(item);
    }

    public E pop(){
        return data.remove(size()-1);
    }

    public E peek(){
        return data.get(size()-1);
    }

    public int size(){
        return data.size();
    }
}
