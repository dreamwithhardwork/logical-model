package org.models.core.validators;

import org.models.core.validators.impl.ModelValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = ModelValidatorImpl.class)
public @interface ModelValidator {
    String message() default "Invalid model type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
