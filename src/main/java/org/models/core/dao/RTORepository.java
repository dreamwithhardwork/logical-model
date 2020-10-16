package org.models.core.dao;

import org.models.core.location.RTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RTORepository extends MongoRepository<RTO,String> {
}
