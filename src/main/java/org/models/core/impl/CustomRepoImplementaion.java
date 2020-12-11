package org.models.core.impl;

import org.bson.Document;
import org.models.core.dao.CustomRepositories;
import org.models.core.domain.Make;
import org.models.core.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Model> getAllModels(){
        Query query = new Query();
        Criteria criteria = new Criteria();
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("variant")
                .localField("name")
                .foreignField("model")
                .as("variants");
        AggregationOperation addFields = new AggregationOperation() {
            @Override
            public Document toDocument(AggregationOperationContext context) {
                return new Document("$addFields", new Document("maxPrice", new Document("$max","$variants.exShowroomPrice")).
                        append("minPrice", new Document("$min","$variants.exShowroomPrice")));
            }
        };
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation,addFields);
        AggregationResults<Model> aggRes = mongoTemplate.aggregate(aggregation,mongoTemplate.getCollectionName(Model.class),Model.class);
        List<Model> modelsList = (List<Model>) aggRes.getRawResults().get("results");
        modelsList.forEach(model -> {
            model.getVariants().forEach(variant -> {
                variant.setSpecifications(null);
            });
        });
        return modelsList;
    }
}
