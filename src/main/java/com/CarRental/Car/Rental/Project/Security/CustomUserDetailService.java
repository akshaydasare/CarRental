package com.CarRental.Car.Rental.Project.Security;

import com.CarRental.Car.Rental.Project.Entities.Customer;
import com.CarRental.Car.Rental.Project.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        UserDetailsClass userDetailsClass= new UserDetailsClass(customer);
        return  userDetailsClass;
    }
}
