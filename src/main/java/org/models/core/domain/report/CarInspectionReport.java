package org.models.core.domain.report;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarInspectionReport {

    private String name;
    private List<ReportObject> values;

}
