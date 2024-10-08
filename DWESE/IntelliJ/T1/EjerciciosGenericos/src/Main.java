public class Main {
    public static void main(String[] args) {
        // EJERCICIOS 1, 2 Y 3
        /*
        PilaGenerica<Integer> pila = new PilaGenerica<>();
        PilaArray<Integer> pila = new PilaArray<>();

        pila.aniadir(2);
        pila.aniadir(3);
        pila.aniadir(4);

        System.out.println("Mostramos la pila completa\n" + pila);

        System.out.println("¿Está vacía la pila? " + pila.estaVacia());

        System.out.println("El primer elemento es " + pila.primero());

        System.out.println("Extraemos el primer elemento...");
        pila.extraer();

        System.out.println("El primer elemento es " + pila.primero());

        System.out.println("Mostramos la pila completa\n" + pila);
        */
        /*
        // EJERCICIOS 5 y 6
        MatrizGenerica<Integer> matriz = new MatrizGenerica<>(4, 2);
        int contador = 1;

        for (int i = 0; i < matriz.filas(); i++) {
            for (int j = 0; j < matriz.columnas(); j++) {
                matriz.set(i, j, contador++);
            }
        }

        System.out.println("Mostramos la matriz completa\n" + matriz);
        System.out.println("Mostramos el elemento en la primera fila, segunda columna: " + matriz.get(0, 1));
        */
        // EJERCICIO 7
        ListaOrdenada<Integer> numeros = new ListaOrdenada<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(4);
        numeros.add(3);

        System.out.println(numeros);

        // ListaOrdenada<PilaArray> pilas = new ListaOrdenada<>();
    }
}