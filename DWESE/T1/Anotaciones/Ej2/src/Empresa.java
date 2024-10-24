import java.util.ArrayList;
import java.util.List;
@DirectivoAn(
        nombre = "Samuel",
        apellidos = "García",
        direccion = "Calle Pegaso, 1",
        dni = "26831411F",
        telefono = "123456789",
        codigoDespacho = 1
)
@TecnicoAn (
        nombre = "Shanshui",
        apellidos = "Wang",
        direccion = "Calle Pegaso, 2",
        dni = "26831422F",
        telefono = "123456789",
        codigoTaller = 1,
        perfil = "Máquina"
)
@OficialAn (
        nombre = "David",
        apellidos = "Alonso",
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

    public Empresa cargadorDeDirectivos(Empresa empresa) {
        DirectivoAn[] anotaciones = Empresa.class.getAnnotationsByType(DirectivoAn.class);

        for (DirectivoAn an : anotaciones) {
            empresa.meter(new Directivo(an.nombre(), an.apellidos(), an.direccion(), an.dni(), an.telefono(), an.codigoDespacho()));
        }
        return empresa;
    }

    public Empresa cargadorDeTecnicos(Empresa empresa) {
        TecnicoAn[] anotaciones = Empresa.class.getAnnotationsByType(TecnicoAn.class);

        for (TecnicoAn an : anotaciones) {
            empresa.meter(new Tecnico(an.nombre(), an.apellidos(), an.direccion(), an.dni(), an.telefono(), an.codigoTaller(), an.perfil()));
        }
        return empresa;
    }

    public Empresa cargadorDeOficiales(Empresa empresa) {
        OficialAn[] anotaciones = Empresa.class.getAnnotationsByType(OficialAn.class);

        for (OficialAn an : anotaciones) {
            empresa.meter(new Oficial(an.nombre(), an.apellidos(), an.direccion(), an.dni(), an.telefono(), an.codigoTaller(), an.categoria()));
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