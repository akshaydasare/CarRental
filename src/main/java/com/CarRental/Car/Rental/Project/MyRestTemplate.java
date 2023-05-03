package com.CarRental.Car.Rental.Project;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyRestTemplate {
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate;
    }



}