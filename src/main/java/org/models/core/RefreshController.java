package org.models.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/refresh")
public class RefreshController {


    @Autowired
    PropertiesListener propertiesListener;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping
    public void refresh(){
           applicationEventPublisher.publishEvent(propertiesListener);
    }

}
