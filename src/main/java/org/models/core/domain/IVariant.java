package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.BodyType;
import org.models.core.enums.FuelType;
import org.models.core.enums.Transmission;
import org.models.core.validators.MakeValidator;
import org.models.core.validators.ModelValidator;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class IVariant {
    @NotNull
    private String variantName;

    @NotNull
    private Transmission transmission;

    @NotNull
    private FuelType fuelType;

    @NotEmpty
    private String description;
    @NotNull
    private Integer fromYear;

    private Integer toYear;
    @NotNull
    private BodyType bodyType;

    @NotNull
    @ModelValidator
    private String model;

    @NotNull
    @MakeValidator
    private String make;

    @NotNull
    private Float exShowroomPrice;
    private List<Image> interiorImages;
    private List<Image> exteriorImages;

    private List<ISpecification> specifications;
}
