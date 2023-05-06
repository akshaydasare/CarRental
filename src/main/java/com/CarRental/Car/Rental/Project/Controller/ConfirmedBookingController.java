package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.DTO.AtmPagePayloadDTO;
import com.CarRental.Car.Rental.Project.DTO.ConfirmedBookingResponseDTO;
import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Repositories.ConfirmedBookingRepository;
import com.CarRental.Car.Rental.Project.Service.ConfirmedBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConfirmedBookingController {
    @Autowired
    ConfirmedBookingService confirmedBookingService;

    @PostMapping("/finalConfirm/{customerId}")
    public ResponseEntity<?> confirmBooking(@RequestBody AtmPagePayloadDTO bookingBody, BindingResult result, @PathVariable int customerId) {

        return confirmedBookingService.confirmBooking(bookingBody, result, customerId);
    }

    @GetMapping("/ticket-details/{userName}")
    public List<ConfirmedBookingResponseDTO> getAllBookings(@PathVariable String userName){
        return confirmedBookingService.getAllBookings(userName);

    }

}