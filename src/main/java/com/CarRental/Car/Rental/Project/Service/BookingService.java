package com.CarRental.Car.Rental.Project.Service;

import com.CarRental.Car.Rental.Project.Entities.Booking;
import com.CarRental.Car.Rental.Project.Entities.Car;
import com.CarRental.Car.Rental.Project.Entities.Driver;
import com.CarRental.Car.Rental.Project.MyRestTemplate;
import com.CarRental.Car.Rental.Project.Repositories.BookingRepository;
import com.CarRental.Car.Rental.Project.Repositories.CarRepository;
import com.CarRental.Car.Rental.Project.Repositories.DriverRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    RestTemplate restTemplate;

public ResponseEntity<?>bookATrip(Booking booking, BindingResult result){
    //TODO : check seating cap of the car and validate the value entered in json
    //TODO: Limit No. of bags =4


    String pickUpLocation = booking.getPickUpLocation();
    String dropLocation = booking.getDropLocation();
    Boolean isValidPickUp=checkPickupValidity(pickUpLocation);
    Boolean isValidDrop=checkDropValidity(dropLocation);

    if(result.hasErrors() || isValidDrop==false||isValidPickUp==false){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some of the fields in the form have an error!");
    }
    //=================================================//
    else {

        //=====================//
        LocalDate pickUpDate = booking.getPickUpDate();
        LocalDate dropDate = booking.getDropDate();
        long days = ChronoUnit.DAYS.between(pickUpDate, dropDate);
        booking.setDays(days);
        //===================//

        int carId = booking.getCar().getId();
        Optional<Car> byId = carRepository.findById(carId);
        Car car = byId.get();
        Integer carCharge = car.getCharge();

        int driverId = booking.getDriver().getId();
        Optional<Driver> byId1 = driverRepository.findById(driverId);
        Driver driver = byId1.get();
        int driverCharges = driver.getCharges();


        //==========================//
        long totalPrice = 0;
        totalPrice = totalPrice + (carCharge + driverCharges) * days;
        Long totalPrice1 = booking.getTotalPrice();
        booking.setTotalPrice(totalPrice);


        Booking savedBooking = bookingRepository.save(booking);

        return ResponseEntity.status(HttpStatus.OK).body("Booking successful! " + savedBooking.getId());

    }

}
public boolean checkPickupValidity(String pickUpLocation){
    String URL= "https://api.postalpincode.in/postoffice/"+pickUpLocation;

    ResponseEntity<JsonNode>responseEntity=restTemplate.getForEntity(URL, JsonNode.class);
    JsonNode body = responseEntity.getBody();
    if(body != null && body.isArray() && body.size() > 0){
        JsonNode firstNode = body.get(0);
        if (firstNode.has("Status")) {
            String status = firstNode.get("Status").asText();
            if ("Success".equals(status)) {
                System.out.println("Inside status=Success");
                return true;
            } else {
                return false;
            }
        }


    }

return false;
}
public boolean checkDropValidity(String dropLocation){

    String URL= "https://api.postalpincode.in/postoffice/"+dropLocation;

    ResponseEntity<JsonNode>responseEntity=restTemplate.getForEntity(URL, JsonNode.class);
    JsonNode body = responseEntity.getBody();
    if(body != null && body.isArray() && body.size() > 0){
        JsonNode firstNode = body.get(0);
        if (firstNode.has("Status")) {
            String status = firstNode.get("Status").asText();
            if ("Success".equals(status)) {
                System.out.println("Inside status=Success");
                return true;
            } else {
                return false;
            }
        }


    }
    return false;

}



}
