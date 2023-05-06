package com.CarRental.Car.Rental.Project.DTO;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingFormPagePayloadDTO {

    private String carId;

    private Long days;
    @Future
    private LocalDate dropDate;

    private String dropLocation;

    private String members;


    @FutureOrPresent
    private LocalDate pickUpDate;

    private String pickUpLocation;

    private LocalTime pickUpTime;

    private Integer passengerCapacity;
    private Integer numBags;

//===========================CONSTRUCTOR GETTER SETTERS=========================================================


    public BookingFormPagePayloadDTO() {
    }

    public BookingFormPagePayloadDTO(String carId, Long days, LocalDate dropDate, String dropLocation, String members, LocalDate pickUpDate, String pickUpLocation, LocalTime pickUpTime, Integer passengerCapacity, Integer numBags) {
        this.carId = carId;
        this.days = days;
        this.dropDate = dropDate;
        this.dropLocation = dropLocation;
        this.members = members;
        this.pickUpDate = pickUpDate;
        this.pickUpLocation = pickUpLocation;
        this.pickUpTime = pickUpTime;
        this.passengerCapacity = passengerCapacity;
        this.numBags = numBags;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getNumBags() {
        return numBags;
    }

    public void setNumBags(Integer numBags) {
        this.numBags = numBags;
    }
}
