public class ListaDobleEncadenada<E> extends AbstractLista<E> {
   private Node<E> head;
   private Node<E> tail;
   private int size;


   public ListaDobleEncadenada(){
       head=null;
       tail=null;
       size=0;
   }

   private static class Node<E>{
       private E data;
       private Node<E> next;
       private Node<E> prev;

       public Node(E data){
           this.data=data;
           this.next=null;
           this.prev=null;
       }
   }

    /**
     * Método para obtener el tamaño de la lista
     * @return size
     */
   public int size(){
       return size;
   }

    /**
     * Método de la interfaz de Lista
     * @return size = 0
     */
   public boolean isEmpty(){
       return size==0;
   }

    /**
     * Método de la interfaz de Lista
     * @param element
     * @return true or false
     */
   public boolean contains(E element){
       Node<E> current = head;
       while(current !=null){
           if(current.data.equals(element)){
               return true;
           }current = current.next;
       }
       return false;
   }

    /**
     * Método de la interfaz de Lista
     * @param element
     */
   public void add(E element){
       Node<E> newNode = new Node<E>(element);
       if(head==null){
           head=newNode;
           tail=newNode;
       }else{
           tail.next=newNode;
           newNode.prev=tail;
           tail=newNode;
       }
       size++;
   }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @param element
     */
   public void add(int index, E element){
       if(index<0||index>size){
           throw new IndexOutOfBoundsException();
       }
       if(index ==0){
           Node<E> newHead = new Node<E>(element);
           newHead.next=head;
           if(head!=null){
               head.prev=newHead;
           }else {
               tail = newHead;
           }
           head = newHead;
       } else if (index == size) {
           Node<E> newTail = new Node<E>(element);
           newTail.prev = tail;
           if(tail !=null){
               tail.next=newTail;
           }else {
               head=newTail;
           }
           tail = newTail;
       }else{
           Node<E> current = head;
           for(int i=0;i<index-1;i++){
               current = current.next;
           }
           Node<E> newNode= new Node<E>(element);
           newNode.next=current.next;
           newNode.prev=current;
           current.next.prev=newNode;
           current.next=newNode;
       }
       size++;
   }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @return dato numerico
     */
   public E get(int index){
       if(index<0||index>=size){
           throw new IndexOutOfBoundsException();
       }
       Node<E> current = head;
       for(int i=0; i<index;i++){
           current=current.next;
       }
       return current.data;
   }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @return dato numerico
     */
   public E remove(int index){
       if(index <0||index>=size){
           throw new IndexOutOfBoundsException();
       }
       E removeData;
       if(size==1){
           removeData=head.data;
           head=null;
           tail=null;
       } else if (index==0) {
           removeData= head.data;
           head=head.next;
           head.prev=null;
       } else if (index==size-1) {
           removeData=tail.data;
           tail=tail.prev;
           tail.next=null;
       }else{
           Node<E> current = head;
           for(int i=0; i<index; i++){
               current=current.next;
           }
           removeData= current.data;
           current.prev.next=current.next;
           current.next.prev=current.prev;
       }return removeData;
   }

    /**
     * Método de la interfaz de Lista
     * @param index
     * @param element
     */
   public void set(int index, E element){

   }

    /**
     * Método de la interfaz de Lista
     */
   public void clear(){
       head=null;
       tail=null;
       size=0;
   }

    /**
     * Método de la interfaz de Lista
     * @param element
     * @return -1
     */
   public int indexOf(E element){
    return -1;
   }
}
