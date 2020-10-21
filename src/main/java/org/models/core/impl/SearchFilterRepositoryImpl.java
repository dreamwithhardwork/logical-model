package org.models.core.impl;

import org.models.core.dao.SearchFilterRepository;
import org.models.core.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class SearchFilterRepositoryImpl implements SearchFilterRepository {

    private static final Logger logger = LoggerFactory.getLogger(SearchFilterRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Vehicle> getVehiclesByFilter(Map<String, Object> filter) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        AtomicReference<Boolean> price= new AtomicReference<>(false);
        AtomicReference<Boolean> mil= new AtomicReference<>(false);
        filter.entrySet().stream().forEach(entry ->
        {
            if(entry.getValue() != null)
            {
                if(entry.getKey().equals("year") ){
                    criteria.and(entry.getKey()).is((Integer) entry.getValue());
                }
                else if((entry.getKey().equals("minMileage") || entry.getKey().equals("maxMileage"))){
                    if(mil.get()==false)
                    criteria.and("mileage").gte(filter.get("minMileage")==null?0:filter.get("minMileage")).lte(filter.get("maxMileage")==null?Integer.MAX_VALUE:filter.get("maxMileage"));
                    mil.set(true);
                }
                else if((entry.getKey().equals("minPrice") || entry.getKey().equals("maxPrice"))){
                    if (price.get()==false)
                    criteria.and("price").gte(filter.get("minPrice")==null?0:filter.get("minPrice")).lte(filter.get("maxPrice")==null?Float.MAX_VALUE:filter.get("maxPrice"));
                    price.set(true);
                }
                else{
                    criteria.and(entry.getKey()).is(entry.getValue());
                }
            }
        }
        );
        query.addCriteria(criteria);
        logger.info(criteria.toString());
        logger.info(query.toString());
        return mongoTemplate.find(query,Vehicle.class);
    }
}
