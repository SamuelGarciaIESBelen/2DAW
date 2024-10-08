import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Repeatable(Tecnicos.class)
public @interface TecnicoAn {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    int codigoTaller();
    String perfil();
}