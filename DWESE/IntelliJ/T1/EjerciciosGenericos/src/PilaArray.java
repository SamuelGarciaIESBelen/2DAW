import java.util.Arrays;

public class PilaArray <T> implements ColeccionSimpleGenerica <T> {
    private T[] pila;
    private int contador;

    public PilaArray() {
        pila = (T[]) new Object[0];
        contador = 0;
    }

    @Override
    public boolean estaVacia() {
        return pila.length == 0;
    }

    @Override
    public T extraer() {
        T elemento = null;

        if (!this.estaVacia()) {
            for (int i = 1; i < contador; i++) {
                pila[i - 1] = pila[i];
            }

            pila = Arrays.copyOf(pila, --contador);
        }


        return elemento;
    }

    @Override
    public T primero() {
        return pila[0];
    }

    @Override
    public void aniadir(T nuevo) {
        pila = Arrays.copyOf(pila, ++contador);
        pila[pila.length - 1] = nuevo;
    }

    @Override
    public String toString() {
        String mensaje = "[";

        for(int i = 0; i < pila.length; i++) {
            mensaje += " " + pila[i];
        };
        return mensaje + " ]";
    }
}
