package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class AvailableVehicleProperties {
    private List<VehicleProperty> engine;
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
    private List<VehicleProperty> communication;
}
