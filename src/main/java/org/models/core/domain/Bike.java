package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.report.BikeInspectionReport;

@Getter
@Setter
@JsonTypeName("BIKE")
public class Bike extends Vehicle {
    private BikeInspectionReport bikeInspectionReport;
}
