package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.PropertyDataType;

import java.util.List;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CarSubSpecification {
    private String name;  // normal name for new cars else report details
    private PropertyDataType propertyDataType;
    private String status; // only used for variants
    private String value; // value yes or no or desc for both reports
    private List<Image> images; // images if any
}

/*
{

}
 */
