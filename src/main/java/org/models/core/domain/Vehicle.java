package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.report.AutomobileType;
import org.models.core.location.RTO;
import org.models.core.users.UnRegisteredUser;
import org.models.core.validators.MakeValidator;
import org.models.core.validators.ModelValidator;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Date;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = Car.class,name = "CAR"), @Type(value = Bike.class,name = "BIKE")})
public abstract class Vehicle {

    private String type;
    @NotNull
    private Integer makeYear;
    private Month makeMonth;
    private Integer registrationYear;
    private Month registrationMonth;
    //@DBRef
    //@NotNull
    private Variant variant;
    private String sellerId;
    private String buyerId;
    //@NotNull
    private Integer noOfOwners;
    //vehicle status (sold, tosell, verification..)
    //@NotNull
    private String status;
    private RTO rto;
    @NotNull
    @MakeValidator
    private String make;
    @NotNull
    @ModelValidator
    private String model;
    @NotNull
    private AutomobileType automobileType;
    private Images sellerImages;
    private Images primaryImages;

    private Date creationDate;
    private Date soldDate;
    private String color;
    private Float sellingPrice;
    private Float costPrice;
    private Integer mileage;
    private Float price;

}
