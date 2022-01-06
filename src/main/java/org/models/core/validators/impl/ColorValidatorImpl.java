package org.models.core.validators.impl;

import org.models.core.validators.ColorValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ColorValidatorImpl  implements ConstraintValidator<ColorValidator, String> {
    @Override
    public void initialize(ColorValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return true;
    }
}
