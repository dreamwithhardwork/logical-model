package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.PropertyDataType;

import java.util.List;

@Getter
@Setter
public class CarSubSpecification {
    private String name;
    private PropertyDataType propertyDataType;
    private String status;
    private String value;
    private List<Image> images;
}
