package org.models.core.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Getter;
import lombok.Setter;
import org.models.core.domain.report.AutomobileType;
import org.models.core.location.RTO;
import org.models.core.users.UnRegisteredUser;
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

    @NotEmpty
    private String type;
    @NotNull
    private Integer makeYear;
    private Month makeMonth;
    private Integer registrationYear;
    private Month registrationMonth;
    @DBRef
    private Variant variant;
    private String sellerId;
    private String buyerId;
    @NotNull
    private Integer noOfOwners;
    //vehicle status (sold, tosell, verification..)
    @NotNull
    private String status;
    private RTO rto;
    @NotNull
    private String make;
    @NotNull
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

// getter setter


    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Images getSellerImages() {
        return sellerImages;
    }

    public void setSellerImages(Images sellerImages) {
        this.sellerImages = sellerImages;
    }

    public Images getPrimaryImages() {
        return primaryImages;
    }

    public void setPrimaryImages(Images primaryImages) {
        this.primaryImages = primaryImages;
    }

    public AutomobileType getAutomobileType() {
        return automobileType;
    }

    public void setAutomobileType(AutomobileType automobileType) {
        this.automobileType = automobileType;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(Integer makeYear) {
        this.makeYear = makeYear;
    }

    public Month getMakeMonth() {
        return makeMonth;
    }

    public void setMakeMonth(Month makeMonth) {
        this.makeMonth = makeMonth;
    }

    public Integer getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(Integer registrationYear) {
        this.registrationYear = registrationYear;
    }

    public Month getRegistrationMonth() {
        return registrationMonth;
    }

    public void setRegistrationMonth(Month registrationMonth) {
        this.registrationMonth = registrationMonth;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getNoOfOwners() {
        return noOfOwners;
    }

    public void setNoOfOwners(Integer noOfOwners) {
        this.noOfOwners = noOfOwners;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RTO getRto() {
        return rto;
    }

    public void setRto(RTO rto) {
        this.rto = rto;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
