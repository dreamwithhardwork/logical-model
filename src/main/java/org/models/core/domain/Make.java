package org.models.core.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.MakeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Document
public class Make {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String logoUrl;
    @NotNull
    private MakeType type;
    private Set<Model> models;

}
