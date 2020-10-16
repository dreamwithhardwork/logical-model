package org.models.core.users;

import lombok.Getter;
import lombok.Setter;
import org.models.core.location.Address;

@Getter
@Setter
public class UnRegisteredUser extends User {
    private Address address;
}
