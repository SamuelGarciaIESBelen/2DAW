public class MatrizGenerica<T> {
    private T[][] matriz;

    public MatrizGenerica(int filas, int columnas) {
        if (filas < 1) {
            filas = 1;
        } if (columnas < 1) {
            columnas = 1;
        }
        this.matriz = (T[][])new Object[filas][columnas];
    }

    public void set(int fila, int columna, T elemento) {
        this.matriz[fila][columna] = elemento;
    }

    public T get(int fila, int columna) {
        return matriz[fila][columna];
    }

    public int columnas() {
        return matriz[0].length;
    }

    public int filas() {
        return matriz.length;
    }

    @Override
    public String toString() {
        String res = "";
        for (T[] fila : matriz) {
            for (T elemento : fila) {
                res += elemento.toString() + " ";
            }
            res += "\n";
        }
        return res;
    }
}
