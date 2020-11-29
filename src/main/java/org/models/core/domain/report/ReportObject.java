package org.models.core.domain.report;

import org.models.core.domain.CarSubSpecification;
import org.models.core.domain.Image;

import java.util.List;

public class ReportObject extends CarSubSpecification {
    private String report;
    private String description;
    private List<Image> images;
}
