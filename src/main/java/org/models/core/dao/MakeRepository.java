package org.models.core.dao;

import org.models.core.domain.Make;
import org.models.core.enums.MakeType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends MongoRepository<Make,String> {
    List<Make> findByType(MakeType makeType);
    Make findOneByName(String name);
}
