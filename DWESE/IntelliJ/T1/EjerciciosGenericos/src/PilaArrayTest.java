import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(pila.estaVacia());
    }

    @Test
    void extraer() {
        pila.aniadir(5);
        assertEquals(5, pila.extraer());
    }

    @Test
    void primero() {
        pila.primero();
    }

}