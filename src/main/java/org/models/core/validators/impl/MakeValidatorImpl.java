package org.models.core.validators.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.models.core.dao.MakeRepository;
import org.models.core.domain.Make;
import org.models.core.error.model.MakeError;
import org.models.core.properies.VehicleProperties;
import org.models.core.validators.MakeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

@Component
public class MakeValidatorImpl implements ConstraintValidator<MakeValidator,String> {

    private static final Logger logger = LoggerFactory.getLogger(MakeValidatorImpl.class);

    @Autowired
    VehicleProperties vehicleProperties;


    @Autowired
    MakeRepository makeRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void initialize(MakeValidator constraintAnnotation) {
        System.out.println(constraintAnnotation.payload().toString());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        Make make =  makeRepository.findOneByName(s);
        isValid = make != null && make.getName().equals(s);
        if(!isValid)
        {
            try {
                String errorMessage = "err"; /*objectMapper.writeValueAsString(MakeError.builder().message("Invalid make type").
                        availableTypes(vehicleProperties.getMakemodelvariants().keySet()).build());
                constraintValidatorContext.disableDefaultConstraintViolation();*/
                constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return isValid;
    }
}
