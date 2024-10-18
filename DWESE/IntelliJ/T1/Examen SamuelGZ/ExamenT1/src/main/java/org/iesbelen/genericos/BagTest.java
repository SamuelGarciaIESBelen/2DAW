package org.iesbelen.genericos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {

    private static Bag<Integer> bolsa;

    @BeforeAll
    public static void setUp() {
        bolsa = new Bag<>();
    }

    @Test
    public void testAdd() {
        System.out.println("Añadimos un 1");
        assertTrue(bolsa.add(1), "No se ha podido añadir el elemento");
        System.out.println("Bolsa\n" + bolsa);
    }

    @Test
    public void testAddN() {
        System.out.println("Añadimos tres 2");
        assertTrue(bolsa.add(2, 3), "No se ha podido añadir el elemento");
        System.out.println("Bolsa\n" + bolsa);
    }

    @Test
    public void TestGetCount() {
        System.out.println("Comprobamos que si contamos el elemento 2, nos devuelva 3");
        bolsa.add(2, 3);
        assertEquals(3, bolsa.getCount(2), "El elemento no aparece ese número de veces");
        System.out.println("Bolsa\n" + bolsa);    }

    @Test
    public void TestRemove() {
        System.out.println("Borramos un elemento 2");
        bolsa.add(1);
        bolsa.add(2);
        assertTrue(bolsa.remove(2), "El elemento no existe");
        System.out.println("Bolsa\n" + bolsa);
    }

    @Test
    public void TestRemoveN() {
        System.out.println("Borramos tres elementos 1");
        bolsa.add(1, 4);
        bolsa.add(2);
        assertTrue(bolsa.remove(1, 3), "El elemento no existe");
        System.out.println("Bolsa\n" + bolsa);
    }

    @Test
    public void TestSize() {
        System.out.println("Devolvemos el tamaño de la bolsa");
        bolsa.add(1, 3);
        assertEquals(3, bolsa.size(), "El elemento no existe");
    }

    @Test
    public void TestUniqueSet() {
        System.out.println("Creamos un conjunto");
        bolsa.add(1, 2);
        bolsa.add(2, 2);
        bolsa.add(3);
        bolsa.add(4);
        HashSet<Integer> conjunto = bolsa.uniqueSet();
        System.out.println("Bolsa\n" + bolsa);
        System.out.println("Conjunto: " + conjunto);
        // No sé bien cómo hacer un assertEquals de esto
    }
}
