import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Repeatable(Directivos.class)
public @interface DirectivoAn {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    int codigoDespacho();
}