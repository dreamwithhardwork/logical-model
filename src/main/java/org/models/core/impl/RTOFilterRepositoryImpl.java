package org.models.core.impl;

import org.models.core.dao.RTOFilterRepository;
import org.models.core.domain.Vehicle;
import org.models.core.location.RTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Map;

public class RTOFilterRepositoryImpl implements RTOFilterRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<RTO> getRTOByFilter(Map<String, String> filter) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        filter.entrySet().stream().forEach(entry ->
                {
                    if(entry.getValue() != null)
                    {
                        if(entry.getKey().equals("operating") ){
                            criteria.and(entry.getKey()).is(Boolean.valueOf(entry.getValue()));
                        }
                        else{
                            criteria.and(entry.getKey()).is(entry.getValue());
                        }
                    }
                }
        );
        query.addCriteria(criteria);

        return mongoTemplate.find(query, RTO.class);
    }
}
