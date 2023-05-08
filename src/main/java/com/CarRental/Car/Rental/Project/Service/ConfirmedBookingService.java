package com.CarRental.Car.Rental.Project.Service;

import com.CarRental.Car.Rental.Project.DTO.AtmPagePayloadDTO;
import com.CarRental.Car.Rental.Project.DTO.ConfirmedBookingResponseDTO;
import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Entities.ConfirmedBooking;
import com.CarRental.Car.Rental.Project.Entities.Customer;
import com.CarRental.Car.Rental.Project.Entities.Driver;
import com.CarRental.Car.Rental.Project.Repositories.BookingRepository;
import com.CarRental.Car.Rental.Project.Repositories.ConfirmedBookingRepository;
import com.CarRental.Car.Rental.Project.Repositories.CustomerRepository;
import com.CarRental.Car.Rental.Project.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConfirmedBookingService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ConfirmedBookingRepository confirmedBookingRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    DriverRepository driverRepository;

    public ResponseEntity<?>confirmBooking( UserDetails userDetails, AtmPagePayloadDTO bookingBody, BindingResult result){
        if (result.hasErrors()){

            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an issue with your fields");

        }
        String username = userDetails.getUsername();
        Customer customer = customerRepository.findByEmail(username);
//        Optional<Customer> byId = customerRepository.findById(customerId);
//            Customer customer = byId.get();
            Booking booking = customer.getBooking();
        Driver driver1 = driverRepository.findById(Integer.parseInt(bookingBody.getDriverID())).get();

        booking.setDriver(driver1);
            booking.setCardNo(bookingBody.getCardNo());


            Long days = booking.getDays();
            Optional<Driver> byId1 = driverRepository.findById(booking.getDriver().getId());
            Driver driver = byId1.get();
            int charges = driver.getCharges();
            Long totalPrice = booking.getTotalPrice();
            totalPrice=totalPrice+(charges*days);
            booking.setTotalPrice(totalPrice);

            bookingRepository.save(booking);


            ConfirmedBooking confirmedBooking=new ConfirmedBooking(booking.getDays(),booking.getDropDate(),booking.getDropLocation(),booking.getMembers(),booking.getNumBags(),booking.getPickUpDate(),booking.getPickUpLocation(),booking.getPickUpTime(),booking.getTotalPrice(),booking.getCar(),booking.getDriver(),booking.getCardNo());
            confirmedBookingRepository.save(confirmedBooking);
            List<ConfirmedBooking> confirmedBookingList = customer.getConfirmedBookingList();
            confirmedBookingList.add(confirmedBooking);
            customer.setConfirmedBookingList(Collections.emptyList());
            customer.setConfirmedBookingList(confirmedBookingList);
            customerRepository.save(customer);

            booking.setDays(null);
            booking.setCardNo(null);
            booking.setCar(null);
            booking.setMembers(null);
            booking.setNumBags(null);
            booking.setTotalPrice(null);
            booking.setPickUpLocation(null);
            booking.setPickUpTime(null);
            booking.setDropLocation(null);
            booking.setDriver(null);
            booking.setDropDate(null);
            bookingRepository.save(booking);

        ConfirmedBookingResponseDTO confirmedBookingResponseDTO=new ConfirmedBookingResponseDTO(customer.getFname(), customer.getLname(), customer.getEmail(),driver.getDriverImg(),driver.getDriverMobNo(), driver.getDriverName(), driver.getCharges(), confirmedBooking.getCar().getCarCompany(),confirmedBooking.getCar().getCarColor(),confirmedBooking.getCar().getCarModel(),confirmedBooking.getCar().getCarType(),confirmedBooking.getCar().getCarImg(),confirmedBooking.getCar().getFuelType(), confirmedBooking.getPickUpLocation(), confirmedBooking.getDropLocation(),confirmedBooking.getPickUpTime(),confirmedBooking.getPickUpDate(),confirmedBooking.getDropDate(),confirmedBooking.getCar().getPassengerCapacity(),Integer.parseInt(confirmedBooking.getMembers()),confirmedBooking.getDays(), confirmedBooking.getCardNo(),confirmedBooking.getFinalCost());


        return ResponseEntity.status(HttpStatus.OK).body(confirmedBookingResponseDTO);


    }

// public ConfirmedBookingResponseDTO(String fname, String lname, String email, String driverImg, Long driverMobNo, String driverName, int charges, String carCompany, String carColor, String carModel, String carType, String carImg, String fuelType, String pickUpLocation, String dropUpLocation, LocalTime pickUpTime, LocalDate pickUpDate, LocalDate dropDate, Integer passengerCapacity, Integer members, Long days, String cardNo, Long finalCost) {
    public ConfirmedBookingResponseDTO convertConfirmBookingToDTO(ConfirmedBooking confirmedBooking,Customer customer,Driver driver){
        ConfirmedBookingResponseDTO confirmedBookingResponseDTO=new ConfirmedBookingResponseDTO(customer.getFname(), customer.getLname(), customer.getEmail(),driver.getDriverImg(),driver.getDriverMobNo(), driver.getDriverName(), driver.getCharges(), confirmedBooking.getCar().getCarCompany(),confirmedBooking.getCar().getCarColor(),confirmedBooking.getCar().getCarModel(),confirmedBooking.getCar().getCarType(),confirmedBooking.getCar().getCarImg(),confirmedBooking.getCar().getFuelType(), confirmedBooking.getPickUpLocation(), confirmedBooking.getDropLocation(),confirmedBooking.getPickUpTime(),confirmedBooking.getPickUpDate(),confirmedBooking.getDropDate(),confirmedBooking.getCar().getPassengerCapacity(),Integer.parseInt(confirmedBooking.getMembers()),confirmedBooking.getDays(), confirmedBooking.getCardNo(),confirmedBooking.getFinalCost());
        return  confirmedBookingResponseDTO;

    }

    public List<ConfirmedBookingResponseDTO>getAllBookings(UserDetails userDetails){

        String username = userDetails.getUsername();
        Customer customer = customerRepository.findByEmail(username);



        List<ConfirmedBooking> confirmedBookingList = customer.getConfirmedBookingList();
        List<ConfirmedBookingResponseDTO> collect = confirmedBookingList.stream().map(x -> convertConfirmBookingToDTO(x, customer, x.getDriver())).collect(Collectors.toList());

        return collect;

    }




}
