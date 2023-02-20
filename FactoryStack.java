import java.util.Stack;

class FactoryStack<E> {

    /**
     * Este método recibe la entrada de texto que indica el tipo de Stack a utilizar
     * @param entry
     * @return El tipo de stack que se desea.
     */
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

    /**
     * Este metodo recibe la entrada de texto que indica el tipo de lista a utilizar.
     * @param entry
     * @return El tipo de lista que se desea.
     */
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