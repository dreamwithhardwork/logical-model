package org.models.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Document
public class Model {
    @Indexed(unique = true)
    private String name;
    private String description;
    private Map<String,String> imagesWithColors;
}
