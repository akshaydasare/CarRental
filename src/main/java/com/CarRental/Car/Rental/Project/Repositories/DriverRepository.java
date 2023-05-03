package com.CarRental.Car.Rental.Project.Repositories;

import com.CarRental.Car.Rental.Project.Entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {



}
