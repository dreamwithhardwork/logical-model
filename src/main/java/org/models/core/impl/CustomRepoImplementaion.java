package org.models.core.impl;

import org.models.core.dao.CustomRepositories;
import org.models.core.domain.Make;
import org.models.core.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomRepoImplementaion implements CustomRepositories {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Make> getAllMakes() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        LookupOperation lookupOperation =  LookupOperation.newLookup()
                .from("model").localField("name").
                foreignField("make").as("models");

        Aggregation aggregation =  Aggregation.newAggregation(lookupOperation);
        List<Make> makes = mongoTemplate.aggregate(aggregation,mongoTemplate.getCollectionName(Make.class),Make.class).getMappedResults();
        return makes;
    }
}
