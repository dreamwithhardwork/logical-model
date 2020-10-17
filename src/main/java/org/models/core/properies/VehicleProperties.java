package org.models.core.properies;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("automobile")
@Getter
@Setter
@Component
public class VehicleProperties {
    private List<String> make;
    private Map<String,List<String>> models;
}
