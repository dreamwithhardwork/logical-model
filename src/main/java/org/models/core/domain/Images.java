package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.ImageType;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Images {

    private Map<String, List<Images>> urls;
}
