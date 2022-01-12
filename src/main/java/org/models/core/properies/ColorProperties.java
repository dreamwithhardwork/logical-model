package org.models.core.properies;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties("automobile")
@Getter
@Setter
@Component
public class ColorProperties {

    private List<String> color;
}
