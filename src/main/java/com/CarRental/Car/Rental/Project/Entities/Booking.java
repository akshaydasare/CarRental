package com.CarRental.Car.Rental.Project.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;

@Entity
@Table
public class Booking {
@Id
String id= UUID.randomUUID().toString();
//generates a random unique string.
@Max(20)
private Integer days;
@Future
private Date dropDate;

private String dropLocation;

private String members;

private int numBags;
//

@FutureOrPresent
private Date pickUpDate;

private String pickUpLocation;

private Time pickUpTime;

private Integer totalPrice;
@OneToOne
private Car car;
@OneToOne
private Driver driver;


}
