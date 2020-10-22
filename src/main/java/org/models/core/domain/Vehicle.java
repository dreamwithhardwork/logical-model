package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.AutomobileType;
import org.models.core.enums.VehicleStatus;
import org.models.core.location.Address;
import org.models.core.location.RTO;
import org.models.core.validators.MakeValidator;
import org.models.core.validators.VehicleValidator;

import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = Car.class,name = "CAR"), @Type(value = Bike.class,name = "BIKE")})
@VehicleValidator
public abstract class Vehicle {

    private String type;
    @NotNull
    private Integer makeYear;
    private Month makeMonth;
    private Integer registrationYear;
    private Month registrationMonth;
    @NotNull
    private Variant variant;
    private String sellerId;
    private String buyerId;
    @NotNull
    private Integer noOfOwners;
    @NotNull
    private VehicleStatus status;
    private RTO rto;
    @NotNull
    @MakeValidator
    private String make;
    @NotNull
    private String model;
    @NotNull
    private AutomobileType automobileType;
    private Images sellerImages;
    private Images primaryImages;


    private Date creationDate=new Date();
    private Date updatedDate;
    private Date soldDate;
    private String color;
    private Float sellingPrice;
    private Float costPrice;
    private Integer mileage;
    private Float price;
    private Address vehicleAddress;

    @JsonIgnore
    private List<Booking> bookings;

}
