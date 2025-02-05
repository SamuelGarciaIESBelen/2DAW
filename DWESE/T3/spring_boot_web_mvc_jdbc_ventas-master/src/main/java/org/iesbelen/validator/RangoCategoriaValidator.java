package org.iesbelen.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {RangoCategoria.class})
public @interface RangoCategoriaValidator {
    public String message() default "{rangoCategoriaError}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
