package org.models.core.domain.report;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BikeInspectionReport  {

    private Map<String,Object> exterior;
    private Map<String,Object> tyres;
    private Map<String,Object> roadTest;
    private Map<String,Object> engineReport;

}
