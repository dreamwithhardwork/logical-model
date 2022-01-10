package org.models.core.validators.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.core.dao.ModelRepository;
import org.models.core.domain.Make;
import org.models.core.domain.Model;
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
public class ModelValidatorImpl implements ConstraintValidator<ModelValidator, String> {

    private static final Logger logger = LoggerFactory.getLogger(ModelValidatorImpl.class);

    @Autowired
    ObjectMapper objectMapper;


    @Autowired
    VehicleProperties vehicleProperties;

    @Autowired
    ModelRepository modelRepository;

    @Override
    public void initialize(ModelValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String modelName, ConstraintValidatorContext constraintValidatorContext) {

        Model model =  modelRepository.findOneByName(modelName);
        boolean valid = model !=null && model.getName().equals(modelName);
        if(!valid){
            try {
                String errorMessage = objectMapper.writeValueAsString("Please create a new model first");
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage());
            }
        }
        return valid;
    }
}
