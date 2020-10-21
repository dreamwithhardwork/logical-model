package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.FuelType;
import org.models.core.enums.Transmission;
import org.models.core.validators.ModelValidator;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ModelValidator
public class Variant {

    @Id
    private String id;
    @NotNull
    private Transmission transmission;
    @NotNull
    private FuelType fuelType;
    @NotEmpty
    private String description;
    @NotNull
    private Integer fromYear;
    private Integer toYear;
    @NotEmpty
    private String model;
    @NotEmpty
    private String make;
    @NotNull
    private String bodyType;

}
