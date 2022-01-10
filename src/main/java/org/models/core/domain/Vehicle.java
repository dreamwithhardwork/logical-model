package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.AutomobileType;
import org.models.core.enums.FuelType;
import org.models.core.enums.Transmission;
import org.models.core.enums.VehicleStatus;
import org.models.core.location.Address;
import org.models.core.location.RTO;
import org.models.core.validators.*;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = Car.class,name = "CAR"), @Type(value = Bike.class,name = "BIKE")})
@VehicleValidator
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public abstract class Vehicle {

    @Id
    private String id;
    //to differentiate vehicle type
    private String type;
    @NotNull
    private Integer makeYear;
    private Month makeMonth;
    @NotNull
    private Integer registrationYear;
    private Month registrationMonth;

    @NotNull
    @VariantValidator
    private IVariant variant;

    private String sellerId;
    private String buyerId;


    @NotNull
    private Integer noOfOwners;

    @NotNull
    private VehicleStatus status;

    private String rto;
    @NotNull
    @MakeValidator
    private String make;
    @NotNull
    @ModelValidator
    private String model;
    @NotNull
    private AutomobileType automobileType;
    private List<Image> sellerImages;
    @NotNull
    private List<Image> primaryImages;


    private Date creationDate=new Date();
    private Date updatedDate;
    private Date soldDate;
    @ColorValidator
    private String color;
    private Float sellingPrice;
    private Float costPrice;
    private Integer mileage;
    private Float price;
    private Address vehicleAddress;
    @NotNull
    private FuelType fuelType;

    @JsonIgnore
    private List<Booking> bookings;

    @NotNull
    private Transmission transmission;

}
