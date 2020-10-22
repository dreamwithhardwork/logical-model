package org.models.core.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.models.core.validators.UserValidator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@UserValidator
public class User {

    @Id
    private String id;
    private String name;
    @Indexed(sparse = true, unique = true)
    private String mobile;
    @Indexed(sparse = true, unique = true)
    private String email;

}
