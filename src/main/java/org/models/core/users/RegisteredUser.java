package org.models.core.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.models.core.location.Address;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Document(collection = "users")
public class RegisteredUser extends User {
    private String username;
    private boolean active;
    private Set<String> roles;
    private List<Address> address;
}
