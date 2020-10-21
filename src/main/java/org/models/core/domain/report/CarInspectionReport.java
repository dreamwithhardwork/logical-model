package org.models.core.domain.report;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CarInspectionReport {

    private Map<String,Object> exterior;
    private Map<String,Object> interior;
    private Map<String,Object> tyres;
    private Map<String,Object> underBody;
    private Map<String,Object> roadTest;
    private Map<String,Object> engineReport;

}
