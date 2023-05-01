package com.CarRental.Car.Rental.Project.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
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

//









}
