import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PilaArrayTest {

    static PilaArray<Integer> pila;
    @BeforeAll
    static void setUp() {
         pila = new PilaArray<>();
    }

    @Test
    void aniadir() {
        pila.aniadir(5);
    }

    @Test
    void estaVacia() {
        pila.estaVacia();
    }

    @Test
    void extraer() {
        pila.extraer();
    }

    @Test
    void primero() {
        pila.primero();
    }


}