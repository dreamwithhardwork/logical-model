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
    private String name;
    private PropertyDataType propertyDataType;
    private String status;
    private String value;
    private List<Image> images;
}
