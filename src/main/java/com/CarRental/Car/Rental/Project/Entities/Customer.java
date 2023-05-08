package com.CarRental.Car.Rental.Project.Entities;

import org.hibernate.engine.internal.Cascade;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Customer {
    //used for registration window.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;
//
    @Email
    @Column(unique = true)
    private String email;
    @Past
    private Date dob;

    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    Booking booking;

    private String role;



    //new added:
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ConfirmedBooking> confirmedBookingList=new ArrayList<>();

    //============================CONSTRUCTORS AND GETTER SETTERS====================================//


    public Customer() {
    }

    public Customer(String fname, String lname, String email, Date dob, String password, List<ConfirmedBooking> confirmedBookingList) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.confirmedBookingList = confirmedBookingList;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setPassword(String password) {
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password=hashpw;
    }

    public List<ConfirmedBooking> getConfirmedBookingList() {
        return confirmedBookingList;
    }

    public void setConfirmedBookingList(List<ConfirmedBooking> confirmedBookingList) {
        this.confirmedBookingList = confirmedBookingList;
    }
}
