public interface IStack<E> {

    /**
     * Agregar un elemento al stack
     * @param item
     */
    public void push(E item);

    /**
     * Obtener el primer elemento del stack
     * @return
     */
    public E pop();

    /**
     * Obtener el primer elemento del stack sin sacarlo de el mismo
     * @return
     */
    public E peek();

    /**
     * Verificar si el stack esta vacío
     * @return
     */
    public boolean empty();

    /**
     * Verificar el tamaño del stack
     * @return
     */
    public int size();
}
