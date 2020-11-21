package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document
public class AvailableCarProperties {
   /* private List<VehicleProperty> engine;
    private List<VehicleProperty> fuel;
    private List<VehicleProperty> suspension;
    private List<VehicleProperty> steering;
    private List<VehicleProperty> brake;
    private List<VehicleProperty> dimensions;
    private List<VehicleProperty> capacity;
    private List<VehicleProperty> comfortAndConvenience;
    private List<VehicleProperty> interior;
    private List<VehicleProperty> exterior;
    private List<VehicleProperty> safety;
    private List<VehicleProperty> entertainment;
    private List<VehicleProperty> communication;*/
    private Map<String,List<VehicleProperty>> availableProps;
}
