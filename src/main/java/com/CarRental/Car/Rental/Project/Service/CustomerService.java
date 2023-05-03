package com.CarRental.Car.Rental.Project.Service;

import com.CarRental.Car.Rental.Project.Entities.Customer;
import com.CarRental.Car.Rental.Project.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class CustomerService {
@Autowired
CustomerRepository customerRepository;


public ResponseEntity<?>customerRegistration(Customer customer, BindingResult result){
    if(result.hasErrors()){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("false");

    }else{
        Customer save = customerRepository.save(customer);
    }
    return ResponseEntity.ok().body(customer);
//In Spring MVC, when we use data binding to map request parameters to a model object,
// the data may not always be valid. For example, a user may forget to fill out a required field or provide invalid input.
//
//To handle such situations, Spring provides the BindingResult class. The BindingResult holds the result of the binding and validation process between the request parameters and the model object.
// It provides methods to check whether there were any binding or validation errors,
// and to access the error messages associated with each field.


}

//get all bookings of user

}
