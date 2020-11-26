package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.FuelType;
import org.models.core.enums.Transmission;
import org.models.core.validators.ModelValidator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ModelValidator
@Document
@CompoundIndex(name = "variant_index", def = "{'variantName':1, 'fromYear':1, 'toYear':1}", unique = true)
@CompoundIndex(name = "variant_model", def = "{'variantName':1, 'model':1}", unique = true)
public class Variant {


    @Id
    @JsonIgnore
    private String _id;

    @Indexed(unique = true)
    @JsonIgnore
    private String _variantName;

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
    private String bodyType;

    @NotNull
    private String model;

    @NotNull
    private Float exShowroomPrice;

    private Map<String,List<String>> interiorImages;
    private Map<String,List<String>> exteriorImages;

    private AvailableCarProperties specifications;

}
