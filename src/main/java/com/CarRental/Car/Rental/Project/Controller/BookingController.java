package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.DTO.BookingFormPagePayloadDTO;
import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookingController {
        @Autowired
        BookingService bookingService;
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping("/book-now")
    public ResponseEntity<?> bookATrip(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody BookingFormPagePayloadDTO booking, BindingResult result ) {

        return bookingService.bookATrip(userDetails,booking,result);


    }
}
