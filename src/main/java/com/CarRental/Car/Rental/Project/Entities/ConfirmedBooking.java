package com.CarRental.Car.Rental.Project.Entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table
public class ConfirmedBooking {

    @Id
    private String id= UUID.randomUUID().toString();
    //generates a random unique string.
    @Max(20)
    private Long days;
    @Future
    private LocalDate dropDate;

    private String dropLocation;

    private String members;

    private int numBags;


    @FutureOrPresent
    private LocalDate pickUpDate;

    private String pickUpLocation;

    private LocalTime pickUpTime;

    private Long finalCost;
    @OneToOne
    private Car car;
    @OneToOne
    private Driver driver;

    //newly added:
//    @ManyToOne
//    @JoinColumn
//    private Customer customer;
    private String cardNo;


    public ConfirmedBooking() {
    }

    public ConfirmedBooking(Long days, LocalDate dropDate, String dropLocation, String members, int numBags, LocalDate pickUpDate, String pickUpLocation, LocalTime pickUpTime, Long finalCost, Car car, Driver driver, String cardNo) {

        this.days = days;
        this.dropDate = dropDate;
        this.dropLocation = dropLocation;
        this.members = members;
        this.numBags = numBags;
        this.pickUpDate = pickUpDate;
        this.pickUpLocation = pickUpLocation;
        this.pickUpTime = pickUpTime;
        this.finalCost = finalCost;
        this.car = car;
        this.driver = driver;

        this.cardNo = cardNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public LocalDate getDropDate() {
        return dropDate;
    }

    public void setDropDate(LocalDate dropDate) {
        this.dropDate = dropDate;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public int getNumBags() {
        return numBags;
    }

    public void setNumBags(int numBags) {
        this.numBags = numBags;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Long getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Long finalCost) {
        this.finalCost = finalCost;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
