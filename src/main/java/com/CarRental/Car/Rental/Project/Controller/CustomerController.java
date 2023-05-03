package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.Entities.Customer;
import com.CarRental.Car.Rental.Project.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
@PostMapping("/customer/registration")
    public ResponseEntity<?> customerRegistration(@RequestBody @Valid Customer customer, BindingResult result){

        return customerService.customerRegistration(customer,result);
    }


}
