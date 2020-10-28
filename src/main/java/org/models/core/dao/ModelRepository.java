package org.models.core.dao;

import org.models.core.domain.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModelRepository extends MongoRepository<Model,String> {
    List<Model> findByMake(String make);
}
