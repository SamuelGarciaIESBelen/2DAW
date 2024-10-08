public class Oficial extends Operario {
    private String categoria;

    public Oficial(String nombre, String apellidos, String direccion, String dni, String telefono, int codigoTaller, String categoria) {
        super(nombre, apellidos, direccion, dni, telefono, codigoTaller);
        this.categoria = categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return super.toString() + " | Categoría: " + categoria;
    }
}
