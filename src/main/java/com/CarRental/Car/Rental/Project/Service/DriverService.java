package com.CarRental.Car.Rental.Project.Service;

import com.CarRental.Car.Rental.Project.Entities.Driver;
import com.CarRental.Car.Rental.Project.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

public ResponseEntity<String>addDriver(Driver driver, BindingResult result){

    if (result.hasErrors()){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter Correct Details");
    }
    else{

        driverRepository.save(driver);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body("Driver Saved Succesfully!"+driver.getDriverName());


}
        public List<Driver> getAllDrivers(){
            List<Driver> driverList = driverRepository.findAll();
                return driverList;

        }

//get drivers

    //post api for booking


}
