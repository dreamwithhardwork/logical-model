package org.models.core.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.MakeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Document
@CompoundIndex(def = "{'name':1,'type':1}")
public class Make {

    @Id
    private String id;
    @NotNull
    private String name;
    @Indexed(unique = true)
    @JsonIgnore
    private String _name;
    private String logoUrl;
    @NotNull
    private MakeType type;
    @JsonIgnore
    @Transient
    private List<Model> models;

    private boolean isPopular;

}
