package org.models.core.domain.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CarInspectionReport {

    private String name;
    private List<ReportObject> values;

}
