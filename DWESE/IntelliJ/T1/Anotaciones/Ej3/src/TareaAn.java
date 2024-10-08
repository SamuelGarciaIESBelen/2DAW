import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Tareas.class)
public @interface TareaAn {
    String titulo();
    String descripcion();
    int dia();
    double hora();
}
