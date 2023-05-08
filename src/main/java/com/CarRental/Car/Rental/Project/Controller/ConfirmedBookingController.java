package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.DTO.AtmPagePayloadDTO;
import com.CarRental.Car.Rental.Project.DTO.ConfirmedBookingResponseDTO;
import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Repositories.ConfirmedBookingRepository;
import com.CarRental.Car.Rental.Project.Service.ConfirmedBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConfirmedBookingController {
    @Autowired
    ConfirmedBookingService confirmedBookingService;
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping("/finalConfirm")
    public ResponseEntity<?> confirmBooking(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AtmPagePayloadDTO bookingBody, BindingResult result) {

        return confirmedBookingService.confirmBooking(userDetails,bookingBody, result);
    }
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("/ticket-details")
    public List<ConfirmedBookingResponseDTO> getAllBookings(@AuthenticationPrincipal UserDetails userDetails){
        return confirmedBookingService.getAllBookings(userDetails);

    }

}