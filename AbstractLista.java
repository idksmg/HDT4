abstract public class AbstractLista<E> implements ILista<E>{
    public AbstractLista(){

    }
    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(E value){
        return -1 != indexOf(value);
    }
}
