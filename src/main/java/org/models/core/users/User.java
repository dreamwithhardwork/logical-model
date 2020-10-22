package org.models.core.users;


import lombok.Getter;
import lombok.Setter;
import org.models.core.validators.UserValidator;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@UserValidator
public class User {
    private String name;
    @Indexed(sparse = true, unique = true)
    private String mobile;
    @Indexed(sparse = true, unique = true)
    private String email;
    private String password;
}
