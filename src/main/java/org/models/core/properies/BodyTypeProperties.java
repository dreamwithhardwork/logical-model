package org.models.core.properies;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties("automobile")
@Getter
@Setter
@Configuration
public class BodyTypeProperties {
    private List<String> bodytype;
}
