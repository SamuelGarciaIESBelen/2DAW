import java.util.ArrayList;
import java.util.List;

@EmpleadoAn(
        clase = "Directivo",
        nombre = "Samuel",
        apellidos = "García",
        direccion = "Calle Pegaso, 1",
        dni = "26831411F",
        telefono = "123456789",
        codigoDespacho = 1
)
@EmpleadoAn(
        clase = "Tecnico",
        nombre = "Shanshui",
        apellidos = "Wang",
        direccion = "Calle Pegaso, 2",
        dni = "26831422F",
        telefono = "123456789",
        codigoTaller = 1,
        perfil = "Máquina"
)
@EmpleadoAn(
        clase = "Oficial",
        nombre = "Daniel",
        apellidos = "Domínguez",
        direccion = "Calle Pegaso, 3",
        dni = "26831433F",
        telefono = "123456789",
        codigoTaller = 1,
        categoria = "Jefe"
)
public class Empresa {
    private String nombre;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList<Empleado>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean meter(Empleado nuevo) {
        return empleados.add(nuevo);
    }

    public boolean sacar(Empleado empleado) {
        return empleados.remove(empleado);
    }

    public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa("Sin nombrar");

        EmpleadoAn[] anotaciones = Empresa.class.getAnnotationsByType(EmpleadoAn.class);

        for (EmpleadoAn ea : anotaciones) {
            if ("Directivo".equals(ea.clase())) {
                Directivo directivo = new Directivo(ea.nombre(), ea.apellidos(), ea.direccion(), ea.dni(), ea.telefono(), ea.codigoDespacho());
                empresa.meter(directivo);
            } else if ("Tecnico".equals(ea.clase())) {
                Tecnico tecnico = new Tecnico(ea.nombre(), ea.apellidos(), ea.direccion(), ea.dni(), ea.telefono(), ea.codigoTaller(), ea.perfil());
                empresa.meter(tecnico);
            } else if ("Oficial".equals(ea.clase())) {
                Oficial oficial = new Oficial(ea.nombre(), ea.apellidos(), ea.direccion(), ea.dni(), ea.telefono(), ea.codigoTaller(), ea.categoria());
                empresa.meter(oficial);
            }
        }
        return empresa;
    }

    @Override
    public String toString() {
        String res = "Empresa: " + nombre + "\nEmpleados:" + "\n";
        for (Empleado empleado : empleados) {
            res += empleado.toString() + "\n";
        }
        return res + "----------------------------------------------------------------------------------------------------------------------------";
    }
}