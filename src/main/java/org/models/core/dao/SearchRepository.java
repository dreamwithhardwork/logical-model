package org.models.core.dao;

import org.models.core.domain.Transmission;
import org.models.core.domain.Vehicle;
import org.models.core.domain.report.AutomobileType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchRepository{

    List<Vehicle> findByAutomobileType(AutomobileType type);
    List<Vehicle> findByMakeAndAutomobileType(String make, AutomobileType type);
    List<Vehicle> findByModelAndAutomobileType(String model, AutomobileType type);
    List<Vehicle> findByColorAndAutomobileType(String color,AutomobileType type);
    List<Vehicle> findByPriceBetweenAndAutomobileType(Float min, Float max, AutomobileType type);
    List<Vehicle> findByMakeYearAndType(Integer year,AutomobileType type);
    @Query("{'fueltype': ?0}")
    List<Vehicle> findVehiclesByFuelTypeAndAutomobileType(String fuelType, AutomobileType type);
    @Query("{'transmission': ?0}")
    List<Vehicle> findVehiclesByTransmissionAndAutomobileType(Transmission transmission, AutomobileType type);
    List<Vehicle> findByMileageBetweenAndAutomobileType(Integer from,Integer to, AutomobileType type);

    //
    List<Vehicle> findByAutomobileTypeAndStatus(AutomobileType type, String status);
    List<Vehicle> findByMakeAndAutomobileTypeAndStatus(String make, AutomobileType type, String status);
    List<Vehicle> findByModelAndAutomobileTypeAndStatus(String model, AutomobileType type, String status);
    List<Vehicle> findByColorAndAutomobileTypeAndStatus(String color,AutomobileType type, String status);
    List<Vehicle> findByPriceBetweenAndAutomobileTypeAndStatus(Float min, Float max, AutomobileType type, String status);
    List<Vehicle> findByMakeYearAndTypeAndStatus(Integer year,AutomobileType type, String status);
    @Query("{'fueltype': ?0}")
    List<Vehicle> findVehiclesByFuelTypeAndAutomobileTypeAndStatus(String fuelType, AutomobileType type, String status);
    @Query("{'transmission': ?0}")
    List<Vehicle> findVehiclesByTransmissionAndAutomobileTypeAndStatus(Transmission transmission, AutomobileType type, String status);
    List<Vehicle> findByMileageBetweenAndAutomobileTypeAndStatus(Integer from,Integer to, AutomobileType type, String status);
/*
    @Query("{'year' :  ?0 , automobiletype: ?1 }")
    List<Vehicle> findVehicleByYearAndType(Integer year,AutomobileType type);


    Page<Vehicle> findByMakeAndType(Pageable pageable,String make, AutomobileType type);
    Page<Vehicle> findByModelAndType(Pageable pageable,String model, AutomobileType type);
    Page<Vehicle> findByYearAndType(Pageable pageable,String model,AutomobileType type);
    Page<Vehicle> findByColorAndType(Pageable pageable,String model,AutomobileType type);
    Page<Vehicle> findByPriceRangeAndType(Pageable pageable,Double min, Double max, AutomobileType type);
    Page<Vehicle> findByMileageAndType(Pageable pageable,Integer mileage, AutomobileType type);
    //Page<Vehicle> findByFuelTypeAndType(Pageable pageable,String fuelType, AutomobileType type);
    Page<Vehicle> findByTransmissionAndType(Pageable pageable,Transmission transmission, AutomobileType type);*/

}
