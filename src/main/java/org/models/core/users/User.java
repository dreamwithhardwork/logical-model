package org.models.core.users;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private Long mobile;
    private String email;
    private String password;
}
