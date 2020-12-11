package org.models.core.domain.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.models.core.domain.CarSubSpecification;
import org.models.core.domain.Image;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ReportObject extends CarSubSpecification {
    private String report;
    private String description;
    private List<Image> images;
}
