package org.iesbelen.validator;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidator;

public class RangoCategoriaPlus implements ConstraintValidator<RangoCategoriaPlusValidator, Integer> {
    private int[] valuesValidos;
    private int max;
    private int min;

    @Override
    public void initialize(RangoCategoriaPlusValidator constraintAnnotation) {
        valuesValidos = constraintAnnotation.values();
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        if (integer >= min && integer <= max) {
            for (int v : valuesValidos) {
                if (v == integer) {
                    return true;
                }
            }
        }
        return false;
    }
}
