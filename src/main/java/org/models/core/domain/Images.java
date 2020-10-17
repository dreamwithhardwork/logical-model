package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Images {
    private Map<String,ImageType> urls;
}
