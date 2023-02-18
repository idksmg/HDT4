import java.util.Iterator;
public interface ILista<E> {

   void add(E element);
   void add(int index, E element);
   E remove(int index);
   E get(int index);
   void set(int index, E element);
   int size();
   boolean isEmpty();
   void clear();
   int indexOf(E element);
   boolean contains(E element);

}
