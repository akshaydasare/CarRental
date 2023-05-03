package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.Entities.Car;
import com.CarRental.Car.Rental.Project.Service.CarService;
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
public class CarController {
    @Autowired
    CarService carService;
    @PostMapping("/car/newCar")
    public ResponseEntity<String> addNewCar(@RequestBody @Valid Car car, BindingResult result) {
        return carService.addNewCar(car,result);

    }

    @GetMapping("/car/allCars")
    public List<Car> getAllCars(){

        return carService.getAllCars();

    }

}
//