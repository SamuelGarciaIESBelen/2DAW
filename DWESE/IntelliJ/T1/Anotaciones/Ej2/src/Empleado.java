public class Empleado {
    private String clase;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String dni;
    private String telefono;

    public Empleado(String nombre, String apellidos, String direccion, String dni, String telefono) {
        clase = this.getClass().getSimpleName();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return clase + " - " + "Nombre: " + this.nombre + " | Apellidos: " + apellidos
                + " | Dirección: " + direccion + " | Dni: " + dni + " | Telefono: " + telefono;
    }
}