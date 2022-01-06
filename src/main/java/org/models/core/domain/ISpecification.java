package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ISpecification {
    @NotNull
    private String name;
    private List<CarSubSpecification> properties;
}
