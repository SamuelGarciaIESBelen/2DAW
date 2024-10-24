import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ListaOrdenada<E extends Comparable<E>>  {
    private List<E> lista;

    public ListaOrdenada() {
        lista = new ArrayList<>();
    }

    public void add(E nuevo) {
        lista.add(nuevo);
        Collections.sort(lista);
    }

    public E get(int index) {
        E elemento = null;

        if (!lista.isEmpty() && index >= 0 && index < lista.size()) {
            elemento = lista.get(index);
        }
        return elemento;
    }

    public int size() {
        return lista.size();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public boolean remove(E elemento) {
        return lista.remove(elemento);
    }

    public int indexOf(E elemento) {
        return lista.indexOf(elemento);
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
