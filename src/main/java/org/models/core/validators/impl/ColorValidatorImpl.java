package org.models.core.validators.impl;

import org.models.core.properies.ColorProperties;
import org.models.core.validators.ColorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class ColorValidatorImpl  implements ConstraintValidator<ColorValidator, String> {


    @Autowired
    private ColorProperties colorProperties;

    @Override
    public void initialize(ColorValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return colorProperties.getColor().contains(value);
    }
}
