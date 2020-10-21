package org.models.core.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Document
public class Otp {
    @Id
    private String id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String otp;
    @NotEmpty
    @Indexed(direction = IndexDirection.DESCENDING)
    @JacksonInject
    private Date date = new Date();
}
