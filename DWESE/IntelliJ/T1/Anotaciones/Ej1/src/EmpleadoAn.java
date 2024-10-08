import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Repeatable(Empleados.class)
public @interface EmpleadoAn {
    String clase();
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    int codigoTaller() default 0;
    int codigoDespacho() default 0;
    String perfil() default "";
    String categoria() default "";
}