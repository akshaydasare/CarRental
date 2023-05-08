package com.CarRental.Car.Rental.Project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   http.csrf().disable().
           authorizeHttpRequests().antMatchers("/login").permitAll().
           antMatchers("/car/newCar").permitAll()
                   .antMatchers("/register").permitAll()
                   .antMatchers("/driver/newDriver").permitAll()
                   .antMatchers("/book-now/{customer_id}").hasAuthority("CUSTOMER")
                   .antMatchers("/cars").hasAuthority("CUSTOMER")
                   .antMatchers("/book-car/{car_id}").hasAuthority("CUSTOMER")
                   .antMatchers("/finalConfirm/{customerId}").hasAuthority("CUSTOMER")
                   .antMatchers("/ticket-details/{userName}").hasAuthority("CUSTOMER")
                   .antMatchers("/drivers").hasAuthority("CUSTOMER").

           anyRequest().authenticated().
           and().exceptionHandling().
           authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and().
           sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
