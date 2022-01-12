package org.models.core;

import org.models.core.dao.CustomRepositories;
import org.models.core.domain.Make;
import org.models.core.domain.Model;
import org.models.core.domain.Variant;
import org.models.core.properies.VehicleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class PropertiesListener implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    CustomRepositories makeRepository;

    @Autowired
    VehicleProperties vehicleProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Make> makes = makeRepository.getAllMakes();
        makes = makes == null ? new ArrayList<>() : makes;
        Iterator<Make> it = makes.iterator();
        Map<String, List<String>> makeModel = new HashMap<>();
        Map<String, List<String>> modelVariant = new HashMap<>();
        vehicleProperties.setMakeModel(makeModel);
        vehicleProperties.setModelVariant(modelVariant);
        while (it.hasNext()) {
            Make make = it.next();
                makeModel.put(make.getName(), (make.getModels()==null?new ArrayList<Model>():make.getModels()).stream().map(m -> {
                    modelVariant.put(m.getName(), (m.getVariants()==null?new ArrayList<Variant>():m.getVariants()).stream().map(v ->
                            v.get_variantName()).collect(Collectors.toList()));
                    return m.getName();
                }).collect(Collectors.toList()));
        }
    }
}

