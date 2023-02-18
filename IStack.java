public interface IStack<E> {

    public void push(E item);
    public E pop();

    public E peek();

    public boolean empty();

    public int size();
}
