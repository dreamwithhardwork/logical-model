package org.models.core.domain.report;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BikeInspectionReport  {

    private Map<String,Object> exterior;
    private Map<String,Object> tyres;
    private Map<String,Object> roadTest;
    private Map<String,Object> engineReport;

    public Map<String, Object> getExterior() {
        return exterior;
    }

    public void setExterior(Map<String, Object> exterior) {
        this.exterior = exterior;
    }

    public Map<String, Object> getTyres() {
        return tyres;
    }

    public void setTyres(Map<String, Object> tyres) {
        this.tyres = tyres;
    }

    public Map<String, Object> getRoadTest() {
        return roadTest;
    }

    public void setRoadTest(Map<String, Object> roadTest) {
        this.roadTest = roadTest;
    }

    public Map<String, Object> getEngineReport() {
        return engineReport;
    }

    public void setEngineReport(Map<String, Object> engineReport) {
        this.engineReport = engineReport;
    }
}
