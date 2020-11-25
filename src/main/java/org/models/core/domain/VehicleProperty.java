package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.PropertyDataType;

@Getter
@Setter
public class VehicleProperty {
    private String name;
    private PropertyDataType propertyDataType;
    private String status;
    private String value;
}
