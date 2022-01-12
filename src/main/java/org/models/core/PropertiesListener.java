package org.models.core;

import org.models.core.dao.CustomRepositories;
import org.models.core.domain.Make;
import org.models.core.properies.VehicleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


//@Component
public class PropertiesListener implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    CustomRepositories makeRepository;

    @Autowired
    VehicleProperties vehicleProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       /* List<Make> makes = makeRepository.getAllMakes();
        makes = makes==null?new ArrayList<>():makes;
        Iterator it =  makes.iterator();
        while (it.hasNext()){
            Make make = (Make) it.next();
            if(vehicleProperties.getMakemodelvariants()==null)
                vehicleProperties.setMakemodelvariants(new HashMap<>());
            //vehicleProperties.getMakes().put(make.getName(),make);
            Map<String, Set<String>> models = new HashMap<>();
            Map<String,Map<String,Set<String>>> makemodelvariants  = vehicleProperties.getMakemodelvariants();
            makemodelvariants.put(make.getName(),models);
            make.getModels().stream().forEach(model -> {
                Set<String> variants ;
                if(model.getVariants()==null) variants = new HashSet<>();
                else {
                    variants=  model.getVariants().stream().map(variant -> {
                        return   variant.getVariantName();
                    }).collect(Collectors.toSet());
                }
                models.put(model.getName(),variants);
            });*/
        }
    }

