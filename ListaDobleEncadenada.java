public class ListaDobleEncadenada<E> extends AbstractLista<E> {
    protected int count;
    protected DobleNode<E> head;
    protected DobleNode<E> tail;

    public ListaDobleEncadenada(){
        head=null;
        tail=null;
        count=0;
    }
    public void addFirst(E value){
        head = new DobleNode<E>(value, head, null);
        if(tail == null) tail = head;
        count++;
    }

    public void addLast(E value){
        tail = new DobleNode<E>(value, null, tail);
        if(head==null) head = tail;
        count++;
    }

    }
}
