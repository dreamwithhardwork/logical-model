package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.models.core.validators.MakeValidator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
@CompoundIndex(name = "make_model", def = "{'_idname':1,'make':1}")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Model {

    @Id
    private String _id;

    @EqualsAndHashCode.Include
    private String name;
    @Indexed(unique = true)
    private String _idname;
    @NotNull
    private String description;
    @NotNull
    private String bodyType;

    private Map<String,List<Image>> imagesWithColors;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Variant> variants;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Float minPrice;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Float maxPrice;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Float maxMileage;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Float engineCC;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<String> fuelTypes;

    @NotNull
    @MakeValidator
    private String make;

    private String logoUrl;

    private  boolean isPopular;

}
