package org.models.core.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Specification extends ISpecification{
    @Id
    private String id;
}

/*
{
  "exterior":{
     "
   }
}
 */