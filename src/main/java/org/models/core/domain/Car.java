package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.report.AutomobileType;
import org.models.core.domain.report.CarInspectionReport;

@Getter
@Setter
@JsonTypeName("CAR")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Car extends Vehicle {
    private CarInspectionReport carInspectionReport;

    public CarInspectionReport getCarInspectionReport() {
        return carInspectionReport;
    }

    public void setCarInspectionReport(CarInspectionReport carInspectionReport) {
        this.carInspectionReport = carInspectionReport;
    }
}
