package com.CarRental.Car.Rental.Project.DTO;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingFormPageResponseDTO {

    private String carCompany;

    private String carColor;

    private String carModel;
    private String carType;
    private String carOwner;
    private String carImg;
    private String numPlate;
    private String insuranceValidity;
    private String fuelType;
    private String feature;
    private String pickUpLocation;
    private String dropUpLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private Integer passengerCapacity;
    private Integer members;
    private Long days;
    private Integer numBags;
    private Long totalPrice;

//====================================CONSTRUCTORS AND GETTER SETTERS=========================================


    public BookingFormPageResponseDTO() {
    }

    public BookingFormPageResponseDTO(String carCompany, String carColor, String carModel, String carType, String carOwner, String carImg, String numPlate, String insuranceValidity, String fuelType, String feature, String pickUpLocation, String dropUpLocation, LocalTime pickUpTime, LocalDate pickUpDate, LocalDate dropDate, Integer passengerCapacity, Integer members, Long days, Integer numBags, Long totalPrice) {
        this.carCompany = carCompany;
        this.carColor = carColor;
        this.carModel = carModel;
        this.carType = carType;
        this.carOwner = carOwner;
        this.carImg = carImg;
        this.numPlate = numPlate;
        this.insuranceValidity = insuranceValidity;
        this.fuelType = fuelType;
        this.feature = feature;
        this.pickUpLocation = pickUpLocation;
        this.dropUpLocation = dropUpLocation;
        this.pickUpTime = pickUpTime;
        this.pickUpDate = pickUpDate;
        this.dropDate = dropDate;
        this.passengerCapacity = passengerCapacity;
        this.members = members;
        this.days = days;
        this.numBags = numBags;
        this.totalPrice = totalPrice;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public String getInsuranceValidity() {
        return insuranceValidity;
    }

    public void setInsuranceValidity(String insuranceValidity) {
        this.insuranceValidity = insuranceValidity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropUpLocation() {
        return dropUpLocation;
    }

    public void setDropUpLocation(String dropUpLocation) {
        this.dropUpLocation = dropUpLocation;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getDropDate() {
        return dropDate;
    }

    public void setDropDate(LocalDate dropDate) {
        this.dropDate = dropDate;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Integer getNumBags() {
        return numBags;
    }

    public void setNumBags(Integer numBags) {
        this.numBags = numBags;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}



