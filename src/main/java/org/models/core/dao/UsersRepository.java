
package org.models.core.dao;

import org.models.core.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User,String> {
}

