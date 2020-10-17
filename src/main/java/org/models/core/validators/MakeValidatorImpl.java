package org.models.core.validators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.core.error.model.MakeError;
import org.models.core.properies.VehicleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class MakeValidatorImpl implements ConstraintValidator<MakeValidator,String> {

    private static final Logger logger = LoggerFactory.getLogger(MakeValidatorImpl.class);

    @Autowired
    VehicleProperties vehicleProperties;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void initialize(MakeValidator constraintAnnotation) {
        System.out.println(constraintAnnotation.payload().toString());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = vehicleProperties.getMake().contains(s);
        if(!isValid)
        {
            try {
                String errorMessage = objectMapper.writeValueAsString(MakeError.builder().message("Invalid make type").availableMakeTypes(vehicleProperties.getMake()).build());
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
            } catch (JsonProcessingException e) {
                logger.error(e.getMessage());
            }
        }
        return isValid;
    }
}
