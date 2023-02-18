public class DobleNode<E> {
    protected E data;
    protected DobleNode<E> nextElement;
    protected DobleNode<E> previousElement;

    public DobleNode(E v, DobleNode<E> next, DobleNode<E> previous){
        data = v;
        nextElement = next;
        previousElement = previous;
        if(nextElement!=null){
            nextElement.previousElement =this;
        }
        if(previousElement !=null){
            previousElement.nextElement= this;
        }
    }
    public DobleNode(E v){
        this(v,null,null);
    }
}
