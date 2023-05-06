package com.CarRental.Car.Rental.Project.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConfirmedBookingResponseDTO {

    private String fname;
    private String lname;
    //
    @Email
    @Column(unique = true)
    private String email;

    private String driverImg;
    //
    private Long driverMobNo;
//IN the DEMO, THIS VALUE IS TAKEN AS INTEGER BUT ITS OUT OF RANGE.

    private String driverName;
    private int charges;

    private String carCompany;

    private String carColor;

    private String carModel;
    private String carType;
    private String carImg;
    private String fuelType;
    private String pickUpLocation;
    private String dropUpLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private Integer passengerCapacity;
    private Integer members;
    private Long days;
    private String cardNo;

    private Long finalCost;


//=============================CONSTRUCTORS AND GETTER SETTERS===============================================//


    public ConfirmedBookingResponseDTO() {
    }

    public ConfirmedBookingResponseDTO(String fname, String lname, String email, String driverImg, Long driverMobNo, String driverName, int charges, String carCompany, String carColor, String carModel, String carType, String carImg, String fuelType, String pickUpLocation, String dropUpLocation, LocalTime pickUpTime, LocalDate pickUpDate, LocalDate dropDate, Integer passengerCapacity, Integer members, Long days, String cardNo, Long finalCost) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.driverImg = driverImg;
        this.driverMobNo = driverMobNo;
        this.driverName = driverName;
        this.charges = charges;
        this.carCompany = carCompany;
        this.carColor = carColor;
        this.carModel = carModel;
        this.carType = carType;
        this.carImg = carImg;
        this.fuelType = fuelType;
        this.pickUpLocation = pickUpLocation;
        this.dropUpLocation = dropUpLocation;
        this.pickUpTime = pickUpTime;
        this.pickUpDate = pickUpDate;
        this.dropDate = dropDate;
        this.passengerCapacity = passengerCapacity;
        this.members = members;
        this.days = days;
        this.cardNo = cardNo;
        this.finalCost = finalCost;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverImg() {
        return driverImg;
    }

    public void setDriverImg(String driverImg) {
        this.driverImg = driverImg;
    }

    public Long getDriverMobNo() {
        return driverMobNo;
    }

    public void setDriverMobNo(Long driverMobNo) {
        this.driverMobNo = driverMobNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
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

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Long getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Long finalCost) {
        this.finalCost = finalCost;
    }
}
