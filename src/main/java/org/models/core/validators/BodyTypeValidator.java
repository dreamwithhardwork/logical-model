package org.models.core.validators;

import org.models.core.validators.impl.ColorValidatorImpl;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = ColorValidatorImpl.class)
public @interface BodyTypeValidator {
}
