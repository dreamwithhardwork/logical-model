package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.BodyType;
import java.util.List;

@Getter
@Setter
@JsonTypeName("CAR")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Car extends Vehicle {
    private BodyType bodyType;
    private List<ISpecification> carInspectionReport;
}
