package org.models.core.validators;


import org.models.core.validators.impl.ColorValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = ColorValidatorImpl.class)
public @interface ColorValidator {
    String message() default "Invalid make type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
