package com.CarRental.Car.Rental.Project.Service;

import com.CarRental.Car.Rental.Project.Entities.Car;
import com.CarRental.Car.Rental.Project.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

public ResponseEntity<String>addNewCar(Car car, BindingResult result){

    if(result.hasErrors()){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter valid details!");

    }
    else {

        carRepository.save(car);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body("Car saved Successfully: "+car.getCarModel());

}

public List<Car> getAllCars(){
    List<Car> allCars = carRepository.findAll();

return allCars;

}

public Car getCarById(int car_id){

    Optional<Car> byId = carRepository.findById(car_id);
    Car car = byId.get();
    return car;

}



}
