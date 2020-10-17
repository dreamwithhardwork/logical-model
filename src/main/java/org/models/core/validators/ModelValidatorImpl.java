package org.models.core.validators;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.core.properies.VehicleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ModelValidatorImpl implements ConstraintValidator<ModelValidator,String> {

    private static final Logger logger = LoggerFactory.getLogger(ModelValidatorImpl.class);

    @Autowired
    ObjectMapper objectMapper;


    @Autowired
    VehicleProperties vehicleProperties;

    @Override
    public void initialize(ModelValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Map<String,List<String>> models = vehicleProperties.getModels();
        AtomicBoolean isValid  = new AtomicBoolean(false);
        models.entrySet().stream().forEach(entry -> {
            if(entry.getValue().contains(s)){
                isValid.set(true);
                return;
            }
        });

        if(!isValid.get())
        {
            try {
               // String errorMessage = objectMapper.writeValueAsString(MakeError.builder().message("Invalid make type").availableMakeTypes(makeList).build());
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("no Model found").addConstraintViolation();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return isValid.get();
    }
}
