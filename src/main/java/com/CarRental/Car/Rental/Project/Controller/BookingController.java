package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.DTO.BookingFormPagePayloadDTO;
import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookingController {
        @Autowired
        BookingService bookingService;
    @PostMapping("/book-now/{customer_id}")
    public ResponseEntity<?> bookATrip(@Valid @RequestBody BookingFormPagePayloadDTO booking, BindingResult result , @PathVariable int customer_id) {

        return bookingService.bookATrip(booking,result,customer_id);


    }
}
