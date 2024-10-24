import java.util.List;
import java.util.LinkedList;

public class PilaGenerica <T> implements ColeccionSimpleGenerica <T> {
    private List<T> pila;

    public PilaGenerica() {
        pila = new LinkedList<T>();
    }

    @Override
    public boolean estaVacia() {
        return pila.isEmpty();
    }

    @Override
    public T extraer() {
        return pila.removeFirst();
    }

    @Override
    public T primero() {
        return pila.getFirst();
    }

    @Override
    public void aniadir(T nuevo) {
        pila.add(pila.size(), nuevo);
    }

    @Override
    public String toString() {
        return pila.toString();
    }
}