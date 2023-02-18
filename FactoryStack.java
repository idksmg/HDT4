import java.util.Stack;

class FactoryStack<E> {

    public Stack<E> getStack(String entry) {
        switch (entry){
            case "AL":
                return new StackArrayList<E>();
            case "VEC":
                return new StackVector<E>();
            case "LIST":
                return new FactoryLista<E>();
            default:
                throw new IllegalArgumentException("Este stack es invalido");
        }

    }
}