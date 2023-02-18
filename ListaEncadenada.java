public class ListaEncadenada<E> extends AbstractLista<E> {
    protected int count;
    protected Node<E> head;

    private static class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data=data;
            this.next=null;
        }
    }

    public ListaEncadenada(){
        this.head = null;
        this.count = 0;
    }


}
