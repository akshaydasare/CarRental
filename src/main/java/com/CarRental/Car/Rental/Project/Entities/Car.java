package com.CarRental.Car.Rental.Project.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String car360;

    private String carColor;

    private String carCompany;

    private String carImg;
    @NotNull
    private String carModel;
    @NotNull
    private String carOwner;
    private String carType;
    @NotNull
    private Integer charge;
    private String feature;
    @NotNull
    private String fuelType;
    @NotNull
    private String insurance;
    @NotNull
    private String insuranceValidity;
    @NotNull
    private String numPlate;
    @NotNull
    private Integer passengerCapacity;
    @PastOrPresent
    private Date regDate;
    private Integer totalRunning;

//should we have a booking field in the car class?
    //if we want to retrieve the booking associated with a car. then the car field must have booking field.

//=================================CONSTRUCTORS AND GETTER SETTERS======================================================//


    public Car() {
    }

    public Car(String car360, String carColor, String carCompany, String carImg, String carModel, String carOwner, String carType, Integer charge, String feature, String fuelType, String insurance, String insuranceValidity, String numPlate, Integer passengerCapacity, Date regDate, Integer totalRunning) {
        this.car360 = car360;
        this.carColor = carColor;
        this.carCompany = carCompany;
        this.carImg = carImg;
        this.carModel = carModel;
        this.carOwner = carOwner;
        this.carType = carType;
        this.charge = charge;
        this.feature = feature;
        this.fuelType = fuelType;
        this.insurance = insurance;
        this.insuranceValidity = insuranceValidity;
        this.numPlate = numPlate;
        this.passengerCapacity = passengerCapacity;
        this.regDate = regDate;
        this.totalRunning = totalRunning;
    }

    public int getId() {
        return id;
    }

    public String getCar360() {
        return car360;
    }

    public void setCar360(String car360) {
        this.car360 = car360;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInsuranceValidity() {
        return insuranceValidity;
    }

    public void setInsuranceValidity(String insuranceValidity) {
        this.insuranceValidity = insuranceValidity;
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getTotalRunning() {
        return totalRunning;
    }

    public void setTotalRunning(Integer totalRunning) {
        this.totalRunning = totalRunning;
    }
}
