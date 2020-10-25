package org.models.core.error.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Builder
public class MakeError {
    private String message;
    private Set<String> availableTypes;
}
