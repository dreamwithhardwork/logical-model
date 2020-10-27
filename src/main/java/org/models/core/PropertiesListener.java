package org.models.core;

import org.models.core.dao.MakeRepository;
import org.models.core.domain.Make;
import org.models.core.properies.VehicleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class PropertiesListener implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    MakeRepository makeRepository;

    @Autowired
    VehicleProperties vehicleProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Make> makes = makeRepository.findAll();
        makes = makes==null?new ArrayList<>():makes;
        makes.forEach(make ->
        {
            if(vehicleProperties.getMakes()==null)
                vehicleProperties.setMakes(new HashMap<>());
            vehicleProperties.getMakes().put(make.getName(),make);
        });
    }
}
