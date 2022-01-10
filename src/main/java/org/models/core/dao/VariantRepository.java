
package org.models.core.dao;

import org.models.core.domain.Variant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantRepository extends MongoRepository<Variant,String> {
    List<Variant> findByModel(String model);
    Variant findOneByVariantNameAndFromYear(String name, Integer year);
    List<Variant> findByMakeAndModel(String make, String model);
    Variant findOneBy_variantName(String name);

}
