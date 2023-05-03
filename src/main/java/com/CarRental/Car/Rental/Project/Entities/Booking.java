package com.CarRental.Car.Rental.Project.Entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;

@Entity
@Table
public class Booking {
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

private Long totalPrice;
@OneToOne
private Car car;
@OneToOne
private Driver driver;

//newly added:
    @ManyToOne
    @JoinColumn
    private Customer customer;



    //===============================CONSTRUCTORS AND GETTER SETTERS==============================================//


    public Booking() {
    }

    public Booking(Long days, LocalDate dropDate, String dropLocation, String members, int numBags, LocalDate pickUpDate, String pickUpLocation, LocalTime pickUpTime, Long totalPrice, Car car, Driver driver, Customer customer) {
        this.days = days;
        this.dropDate = dropDate;
        this.dropLocation = dropLocation;
        this.members = members;
        this.numBags = numBags;
        this.pickUpDate = pickUpDate;
        this.pickUpLocation = pickUpLocation;
        this.pickUpTime = pickUpTime;
        this.totalPrice = totalPrice;
        this.car = car;
        this.driver = driver;
        this.customer = customer;
    }

    public String getId() {
        return id;
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

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
