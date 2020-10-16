package org.models.core.dao;

import org.models.core.users.UnRegisteredUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnregisteredUserRepository extends MongoRepository<UnRegisteredUser,String> {
}
