public class Operario extends Empleado {
    private int codigoTaller;

    public Operario(String nombre, String apellidos, String direccion, String dni, String telefono, int codigoTaller) {
        super(nombre, apellidos, direccion, dni, telefono);
        this.codigoTaller = codigoTaller;
    }

    public void setCodigoTaller(int codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

    public int getCodigoTaller() {
        return codigoTaller;
    }

    @Override
    public String toString() {
        return super.toString() + " | Código Taller: " + codigoTaller;
    }
}
