package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
@CompoundIndex(name = "make_model", def = "{'_idname':1,'make':1}")
public class Model {

    @Id
    private String _id;

    @EqualsAndHashCode.Include
    private String name;

    @Indexed(unique = true)
    private String _idname;
    @NotNull
    private String description;
    private Map<String,List<Image>> imagesWithColors;
    @JsonIgnore
    @Transient
    private List<Variant> variants;
    @NotNull
    private String make;

    private String logoUrl;

    private  boolean isPopular;

}
