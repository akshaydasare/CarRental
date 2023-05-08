package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.Entities.Customer;
import com.CarRental.Car.Rental.Project.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    //TODO ALL
@PostMapping("/register")
@Transactional
    public ResponseEntity<?> customerRegistration(@RequestBody @Valid Customer customer, BindingResult result){

        return customerService.customerRegistration(customer,result);
    }


    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        new SecurityContextLogoutHandler().logout(request, null, null);
        return ResponseEntity.ok().build();
    }


}
