package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.BodyType;
import org.models.core.enums.FuelType;
import org.models.core.enums.Transmission;
import org.models.core.validators.ModelValidator;
import org.models.core.validators.VariantValidator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document
@CompoundIndex(name = "variant_index", def = "{'_variantName':1, 'model':1, 'fromYear':1}", unique = true)
@CompoundIndex(name = "variant_model", def = "{'_variantName':1, 'model':1}", unique = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Variant extends IVariant{
    @Id
    private String _id;

    private String _variantName; // variantname+year
}
