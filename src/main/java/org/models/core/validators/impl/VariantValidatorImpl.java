package org.models.core.validators.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.models.core.dao.VariantRepository;
import org.models.core.domain.IVariant;
import org.models.core.domain.Variant;
import org.models.core.util.Util;
import org.models.core.validators.VariantValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class VariantValidatorImpl implements ConstraintValidator<VariantValidator, IVariant> {

    private static final Logger logger = LoggerFactory.getLogger(MakeValidatorImpl.class);

    @Autowired
    VariantRepository  variantRepository;

    @Override
    public boolean isValid(IVariant variant, ConstraintValidatorContext context) {
       boolean isValid = false;
        try{
            Variant v = variantRepository.findOneBy_variantName(Util.generateIdFromUniqueName(variant.getVariantName()+variant.getFromYear()));
            isValid = (v != null);
        }catch (Exception ex){
          logger.info(ex.getMessage());
        }
        if (!isValid) {
                String errorMessage = "Please create a valid variant first";
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
        }

        return isValid;
    }
}
