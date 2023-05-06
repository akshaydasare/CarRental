package com.CarRental.Car.Rental.Project.Repositories;

import com.CarRental.Car.Rental.Project.Entities.ConfirmedBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmedBookingRepository extends JpaRepository<ConfirmedBooking,Integer> {
}
