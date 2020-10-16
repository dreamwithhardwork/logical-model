package org.models.core.dao;

import org.models.core.domain.Vehicle;

import java.util.List;
import java.util.Map;

public interface SearchFilterRepository {
    List<Vehicle> getVehiclesByFilter(Map<String,String> filter);
}
