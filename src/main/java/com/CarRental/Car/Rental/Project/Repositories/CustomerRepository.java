package com.CarRental.Car.Rental.Project.Repositories;

import com.CarRental.Car.Rental.Project.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
