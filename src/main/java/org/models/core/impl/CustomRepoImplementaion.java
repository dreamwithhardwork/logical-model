package org.models.core.impl;

import org.bson.Document;
import org.models.core.dao.CustomRepositories;
import org.models.core.domain.Make;
import org.models.core.domain.Model;
import org.models.core.domain.ModelsFilter;
import org.models.core.enums.FuelType;
import org.models.core.enums.MakeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

        List<Document> doc = (List<Document>) mongoTemplate.aggregate(aggregation,mongoTemplate.getCollectionName(Make.class),Make.class).getRawResults().get("results");
        List<Make> makes = new ArrayList<>();
        doc.forEach(item -> {
            Make make = new Make();
            make.set_name(item.getString("_name"));make.setId(item.getString("id"));make.setName(item.getString("name"));
            make.setLogoUrl(item.getString("logoUrl"));
            make.setPopular(item.get("isPopular",Boolean.class));
            List<Model> models = new ArrayList<>();

            List<Document> modDoc = item.get("models",List.class);
            modDoc.forEach(mo -> {
                Model model = new Model();
                model.setName(mo.getString("name"));
                models.add(model);
            });
            make.setModels(models);
            makes.add(make);
        });
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
                        append("minPrice", new Document("$min","$variants.exShowroomPrice"))
                        .append("fuelTypes",new Document("$setUnion",Arrays.asList(new ArrayList(),"$variants.fuelType")))
                        );
            }
        };
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation,addFields);
        AggregationResults<Model> aggRes = mongoTemplate.aggregate(aggregation,mongoTemplate.getCollectionName(Model.class),Model.class);
        List<Model> modelsList = (List<Model>) aggRes.getRawResults().get("results");
        return modelsList;
    }

    public List<Model> getAllModels(ModelsFilter filter){
        Query query = new Query();
        Criteria criteria = new Criteria();
        List<String> bodyTypes  = filter.getBodyTypes();
        List<FuelType> fuelTypes = filter.getFuelTypes();
        List<String> makeList = filter.getMakeList();
        Float max =filter.getMaxPrice();
        Float min = filter.getMinPrice();

        List<Document> finalFilter = new ArrayList<>();

        List<Document> bodyTypeDoc = new ArrayList<>();
        bodyTypes.forEach(type -> bodyTypeDoc.add(new Document("bodyType",type)));
        if (bodyTypeDoc.size()!=0){
            finalFilter.add(new Document("$or",bodyTypeDoc));
        }

        List<Document> makeTypeDoc = new ArrayList<>();
        makeList.forEach(type -> makeTypeDoc.add(new Document("make",type)));
        if(makeTypeDoc.size() !=0){
            finalFilter.add(new Document("$or",makeTypeDoc));
        }


        Document minPriceDoc = new Document("minPrice", new Document("$gte",min));
        Document maxPriceDoc = new Document("maxPrice", new Document("$lte",max));
        finalFilter.add(new Document("$and",Arrays.asList(minPriceDoc,maxPriceDoc)));


        AggregationOperation matchOperation = new AggregationOperation() {
            @Override
            public Document toDocument(AggregationOperationContext context) {
                return new Document("$match",
                        new Document("$and", finalFilter));
            }
        };


        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("variant")
                .localField("name")
                .foreignField("model")
                .as("variants");
        AggregationOperation addFields = new AggregationOperation() {
            @Override
            public Document toDocument(AggregationOperationContext context) {
                return new Document("$addFields", new Document("maxPrice", new Document("$max","$variants.exShowroomPrice")).
                        append("minPrice", new Document("$min","$variants.exShowroomPrice"))
                        .append("fuelTypes",new Document("$setUnion",Arrays.asList(new ArrayList(),"$variants.fuelType")))
                );
            }
        };


        Aggregation aggregation = Aggregation.newAggregation(lookupOperation,addFields,matchOperation);
        AggregationResults<Model> aggRes = mongoTemplate.aggregate(aggregation,mongoTemplate.getCollectionName(Model.class),Model.class);
        List<Model> modelsList = (List<Model>) aggRes.getRawResults().get("results");
        return modelsList;
    }
}
