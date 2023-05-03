package com.CarRental.Car.Rental.Project.Repositories;

import com.CarRental.Car.Rental.Project.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
