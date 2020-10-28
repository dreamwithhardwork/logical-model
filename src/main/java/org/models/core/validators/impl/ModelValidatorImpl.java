package org.models.core.validators.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.core.domain.Make;
import org.models.core.domain.Variant;
import org.models.core.domain.Vehicle;
import org.models.core.error.model.MakeError;
import org.models.core.properies.VehicleProperties;
import org.models.core.validators.ModelValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ModelValidatorImpl implements ConstraintValidator<ModelValidator, Object> {

    private static final Logger logger = LoggerFactory.getLogger(ModelValidatorImpl.class);

    @Autowired
    ObjectMapper objectMapper;


    @Autowired
    VehicleProperties vehicleProperties;

    @Override
    public void initialize(ModelValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        Map<String, Set<String>> make;
        String makename = "" ,modelName="";
        if(obj instanceof Vehicle)
        {
            makename = ((Vehicle)obj).getMake();
            modelName = ((Vehicle)obj).getModel();
        }
        make = vehicleProperties.getMakemodelvariants().get(makename);


        boolean valid = make.keySet().contains(modelName);
        if(!valid){
            try {
                Set<String> models = make.keySet();
                String errorMessage = objectMapper.writeValueAsString(MakeError.builder().message("Invalid Model type").
                        availableTypes(models).build());
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage());
            }
        }
        return valid;
    }
}
