package org.models.core.users;


import lombok.Getter;
import lombok.Setter;
import org.models.core.validators.UserValidator;

@Getter
@Setter
@UserValidator
public class User {
    private String name;
    private String mobile;
    private String email;
    private String password;
}
