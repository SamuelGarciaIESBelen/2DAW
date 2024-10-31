package org.iesbelen.anotaciones;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Credenciales.class)

public @interface CredencialAn {
    String usuario();
    String hashPasswd();
}
