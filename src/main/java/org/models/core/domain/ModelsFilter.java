package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.FuelType;
import org.models.core.enums.Transmission;

import java.util.List;

@Getter
@Setter
public class ModelsFilter {
    private List<String> makeList;
    private List<String> modelList;
    private Float minPrice;
    private Float maxPrice;
    private List<FuelType> fuelTypes;
    private List<String> bodyTypes;
    private List<Transmission> transmissionList;
}
