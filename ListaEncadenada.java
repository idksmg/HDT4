public class ListaEncadenada<E> extends AbstractLista<E> {
    private int count;
    private Node<E> head;

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

    /**
     * Método de la interfaz de Lista
     * @return count
     */
    public int size(){
        return count;
    }

    /**
     * Método de la interfaz de Lista
     * @return count = 0;
     */
    public boolean isEmpty(){
        return count ==0;
    }

    /**
     * Método de la interfaz de Lista
     * @param value
     * @return true or false
     */
    @Override
    public boolean contains(E value) {
        Node<E> current = head;
        while(current != null){
            if(current.data.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Método de la interfaz de Lista
     * @param element
     */
    public void add(E element){
        if(head == null){
            head = new Node<E>(element);
        }else{
            Node<E> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node<E>(element);
        }
        count++;
    }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @param element
     */
    public void add(int index, E element){
        if (index<0|| index> count){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            Node<E> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        }else{
            Node<E> current = head;
            for(int i=0;i<index-1;i++){
                current = current.next;
            }
            Node<E> newNode = new Node<E>(element);
            newNode.next = current.next;
            current.next= newNode;
        }
        count++;
    }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @return dato numerico
     */
    public E remove(int index){
        if(index <0 ||index>= count){
            throw new IndexOutOfBoundsException();
        }
        E removeData;
        if(index == 0){
            removeData = head.data;
            head = head.next;
        }else{
            Node<E> current = head;
            for(int i=0; i<index-1; i++){
                current = current.next;
            }
            removeData = current.next.data;
            current.next= current.next.next;
        }
        count--;
        return removeData;
    }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @return dato numerico
     */
    public E get(int index){
        if(index<0||index>=count){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        return current.data;
    }

    /**
     * Método de la interfaz de Lista
     */
    public void clear(){
        head = null;
        count=0;
    }

    /**
     * Método de la interfaz de Lista
     * @param element
     * @return -1
     */
    public int indexOf(E element){
        int index = 0;
        Node<E> current = head;
        while(current!=null){
            if(current.data.equals(element)){
                return index;
            }
            index++;
            current=current.next;
        }
        return -1;
    }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @param element
     */
    public void set(int index, E element){
        if(index<0||index>=count){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for(int i=0; i<index;i++){
            current=current.next;
        }
        current.data=element;
    }

}
