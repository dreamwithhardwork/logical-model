package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.PropertyDataType;

@Getter
@Setter
public class VehicleProperty {
    private String name;
    private PropertyDataType propertyDataType;
    @JsonIgnore
    private String value;
}
