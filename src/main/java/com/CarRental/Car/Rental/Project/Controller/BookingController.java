package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookingController {
        @Autowired
        BookingService bookingService;
    @PostMapping("/booking/bookATrip")
    public ResponseEntity<?> bookATrip(@Valid @RequestBody Booking booking, BindingResult result) {

        return bookingService.bookATrip(booking,result);


    }
}
