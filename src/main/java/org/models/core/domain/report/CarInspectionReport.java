package org.models.core.domain.report;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.VehicleProperty;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CarInspectionReport {

    private String name;
    private List<ReportObject> values;

}
