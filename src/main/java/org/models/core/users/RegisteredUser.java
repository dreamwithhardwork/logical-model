package org.models.core.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.Roles;
import org.models.core.location.Address;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Document(collection = "users")
public class RegisteredUser extends User {
    private boolean active;
    private List<Roles> roles;
    private List<Address> address;
    private String password;
}
