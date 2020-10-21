package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.report.CarInspectionReport;
import org.models.core.enums.FuelType;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonTypeName("CAR")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Car extends Vehicle {
    private CarInspectionReport carInspectionReport;
    @NotNull
    private FuelType fuelType;
}
