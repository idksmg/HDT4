import java.util.Stack;

class FactoryStack<E> {

    public IStack<E> getStack(String entry) {
        if(entry == null){
            return null;
        }
        if(entry.equalsIgnoreCase("AL")){
            return new StackArrayList<E>();
        }
        if(entry.equalsIgnoreCase("VEC")){
            return new StackVector<E>();
        }
        return null;
    }
    public ILista<E> getLista(String entry){
        if(entry == null){
            return null;
        }
        if(entry == "ENC"){
            return new ListaEncadenada<E>();
        }
        if(entry == "DENC"){
            return new ListaDobleEncadenada<E>();
        }
        return null;
    }

}