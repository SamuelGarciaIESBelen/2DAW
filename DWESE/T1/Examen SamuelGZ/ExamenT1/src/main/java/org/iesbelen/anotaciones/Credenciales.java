package org.iesbelen.anotaciones;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Credenciales {
    CredencialAn[] value();
}
