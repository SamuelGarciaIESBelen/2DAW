import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Repeatable(Oficiales.class)
public @interface OficialAn {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    int codigoTaller();
    String categoria();
}