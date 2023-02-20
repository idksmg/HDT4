import java.util.Iterator;
public interface ILista<E> {

   /**
    * Método para los elementos de la lista
    * @param element
    */
   /**
    * Método para agregar a la lista
    * @param element
    */
   void add(E element);

   /**
    * Método para agregar un elemento en base a su indice
    * @param index
    * @param element
    */
   void add(int index, E element);

   /**
    * Método para remover un elemento de la lista en base a su indice
    * @param index
    * @return
    */
   E remove(int index);

   /**
    * Método para obtener un elemento de la lista en base a su indice
    * @param index
    * @return
    */
   E get(int index);

   /**
    * Método para settear un elemento en base a su indice
    * @param index
    * @param element
    */
   void set(int index, E element);

   /**
    * Método para obtener el tamaño de la lista
    * @return
    */
   int size();

   /**
    * Método para verificar si la lista esta vacia
    * @return
    */
   boolean isEmpty();

   /**
    * Método para limpiar la lista
    */
   void clear();

   /**
    * Método para obtener el indice en base a un elemento
    * @param element
    * @return
    */
   int indexOf(E element);

   /**
    * Método para verificar si la lista contiene determinado elemento
    * @param element
    * @return
    */
   boolean contains(E element);

}
