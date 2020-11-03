package org.models.core.dao;

import org.models.core.domain.AvailableCarProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableCarPropertiesRepository extends MongoRepository<AvailableCarProperties, String> {
}
