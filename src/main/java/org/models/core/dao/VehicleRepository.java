package org.models.core.dao;

import org.models.core.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends SearchRepository, MongoRepository<Vehicle,String> {
}
