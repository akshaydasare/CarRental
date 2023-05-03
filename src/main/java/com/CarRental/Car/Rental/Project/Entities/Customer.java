package com.CarRental.Car.Rental.Project.Entities;

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

    //new added:
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customer")
    private List<Booking> bookingList=new ArrayList<>();

    //============================CONSTRUCTORS AND GETTER SETTERS====================================//


    public Customer() {
    }

    public Customer(String fname, String lname, String email, Date dob, String password, List<Booking> bookingList) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.bookingList = bookingList;
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


    public void setPassword(String password) {
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password=hashpw;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
