package org.models.core.validators;


import org.models.core.validators.impl.ColorValidatorImpl;
import org.models.core.validators.impl.MakeValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = MakeValidatorImpl.class)
public @interface MakeValidator {
    String message() default "Invalid Color";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
