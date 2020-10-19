package org.models.core.users;

import lombok.Getter;
import lombok.Setter;
import org.models.core.location.Address;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RegisteredUser extends User {
    private String username;
    private boolean active;
    private Set<String> roles;
    private List<Address> address;
}
