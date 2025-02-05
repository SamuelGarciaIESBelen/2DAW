package org.iesbelen.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {RangoCategoriaPlus.class})
public @interface RangoCategoriaPlusValidator {
    int[] values();
    int max();
    int min();

    public String message() default "{rangoCategoriaPlusError}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
