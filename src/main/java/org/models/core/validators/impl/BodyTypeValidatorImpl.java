package org.models.core.validators.impl;

import org.models.core.properies.BodyTypeProperties;
import org.models.core.properies.ColorProperties;
import org.models.core.validators.BodyTypeValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BodyTypeValidatorImpl implements ConstraintValidator<BodyTypeValidator,String> {


    @Autowired
    private BodyTypeProperties bodyTypeProperties;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return bodyTypeProperties.getBodytype().contains(value);
    }
}
