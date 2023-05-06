package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.Entities.Driver;
import com.CarRental.Car.Rental.Project.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;
    @PostMapping("/driver/newDriver")
    public ResponseEntity<String> addDriver(@RequestBody @Valid Driver driver, BindingResult result){

        return driverService.addDriver(driver,result);

    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers(){

        return driverService.getAllDrivers();
    }

}
