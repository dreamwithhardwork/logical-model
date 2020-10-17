package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Variant {

    @Id
    private String id;
    private Transmission transmission;
    private String fuelType;
    private String description;
    private Integer fromYear;
    private Integer toYear;
    private String model;
    private String make;
    private String bodyType;

}
