abstract public class AbstractLista<E> implements ILista<E>{
    public AbstractLista(){

    }

    /**
     * Este método nos indica si la lista esta vacia o no
     * @return size = 0
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     *
     * @param value
     * @return -1 si el indice es distinto del valor generico
     */
    public boolean contains(E value){
        return -1 != indexOf(value);
    }
}
