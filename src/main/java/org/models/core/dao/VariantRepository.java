
package org.models.core.dao;

import org.models.core.domain.Variant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends MongoRepository<Variant,String> {
}
