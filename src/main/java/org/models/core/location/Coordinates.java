package org.models.core.location;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Coordinates {

    private String type;
    private List<Double> coordinates;
}
