package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.Entities.Car;
import com.CarRental.Car.Rental.Project.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cars")
    public List<Car> getAllCars(){

        return carService.getAllCars();

    }

    @GetMapping("/book-car/{car_id}")
    public Car getCarById(@PathVariable int car_id){
    return carService.getCarById(car_id);



    }

}
//