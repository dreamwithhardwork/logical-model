package org.models.core.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Document
public class Specification {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String name;
    private List<CarSubSpecification> properties;
}
