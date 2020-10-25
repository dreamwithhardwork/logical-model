package org.models.core.properies;

import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.Make;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@ConfigurationProperties("automobile")
@Getter
@Setter
@Component
public class VehicleProperties {
    private List<String> make;
    private Map<String,Set<String>> models;
    private Map<String,Make> makes;
}
