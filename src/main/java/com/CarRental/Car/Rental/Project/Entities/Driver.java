package com.CarRental.Car.Rental.Project.Entities;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class Driver {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private String availability;
@Min(100)
private int charges;

private String drink;
private String driverImg;
//

private Long driverMobNo;
//IN the DEMO, THIS VALUE IS TAKEN AS INTEGER BUT ITS OUT OF RANGE.

private String driverName;

private String drivingExperience;

private String food;
private String smoke;

//=============================CONSTRUCTORS AND GETTER SETTERS================================================//


    public Driver() {
    }

    public Driver(String availability, int charges, String drink, String driverImg, Long driverMobNo, String driverName, String drivingExperience, String food, String smoke) {
        this.availability = availability;
        this.charges = charges;
        this.drink = drink;
        this.driverImg = driverImg;
        this.driverMobNo = driverMobNo;
        this.driverName = driverName;
        this.drivingExperience = drivingExperience;
        this.food = food;
        this.smoke = smoke;
    }

    public int getId() {
        return id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
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

    public String getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(String drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }
}
