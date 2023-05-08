package com.CarRental.Car.Rental.Project.Controller;

import com.CarRental.Car.Rental.Project.DTO.JwtAuthRequest;
import com.CarRental.Car.Rental.Project.DTO.JwtAuthResponse;
import com.CarRental.Car.Rental.Project.Security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    //TODO ALL
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse>createToken(@RequestBody JwtAuthRequest request){

    this.authenticate(request.getUsername(),request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());


        String token = this.jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse jwtAuthResponse= new JwtAuthResponse();
        jwtAuthResponse.setToken(token);
        return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken
                (username,password);
        try{

            authenticationManager.authenticate(usernamePasswordAuthenticationToken);



        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
