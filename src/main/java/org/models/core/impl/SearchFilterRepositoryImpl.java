package org.models.core.impl;

import org.models.core.dao.SearchFilterRepository;
import org.models.core.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SearchFilterRepositoryImpl implements SearchFilterRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Vehicle> getVehiclesByFilter(Map<String, String> filter) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        filter.entrySet().stream().forEach(entry ->
        {
            if(entry.getValue() != null)
            {
                if(entry.getKey().equals("year") ){
                    criteria.and(entry.getKey()).is(Integer.valueOf(entry.getValue()));
                }
                else if(entry.getKey().equals("minMileage")){
                    criteria.and(entry.getKey()).gte(Integer.valueOf(entry.getValue()));
                }
                else if(entry.getKey().equals("maxMileage")){
                    criteria.and(entry.getKey()).lte(Integer.valueOf(entry.getValue()));
                }
                else if(entry.getKey().equals("minPrice")){
                    criteria.and(entry.getKey()).gte(Float.valueOf(entry.getValue()));
                }
                else if(entry.getKey().equals("maxPrice")){
                    criteria.and(entry.getKey()).lte(Float.valueOf(entry.getValue()));
                }
                else{
                    criteria.and(entry.getKey()).is(entry.getValue());
                }
            }
        }
        );
        query.addCriteria(criteria);

        return mongoTemplate.find(query,Vehicle.class);
    }
}
