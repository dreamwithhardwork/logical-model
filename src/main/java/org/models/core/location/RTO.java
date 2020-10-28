package org.models.core.location;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Document(collection = "rto")
public class RTO {

    @Id
    private String id;
    //KA07
    @NotNull
    private String code;
    @NotNull
    private String state;
    @NotNull
    private String district;
    //
    @NotNull
    private Boolean operating;

    @NotBlank
    private String location;

    private List<Address> addresses;

}
