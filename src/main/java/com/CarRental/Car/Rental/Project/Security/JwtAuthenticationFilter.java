package com.CarRental.Car.Rental.Project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    JwtTokenHelper jwtTokenHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestToken = request.getHeader("Authorization");

        String username= null;
        String token=null;

        if(requestToken!=null && requestToken.startsWith("Bearer")){
            token=requestToken.substring(7);
            try{
                username=jwtTokenHelper.getUsernameFromToken(token);

            }catch (Exception e){

                e.printStackTrace();

            }




        }
        else {
            System.out.println("JWT TOKEN DOES NOT BEGIN WITH BEARER");
        }

        //once we get the token ,validate it

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.jwtTokenHelper.validateToken(token,userDetails)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);



            }else {
                System.out.println("Invalid JWT TOKEN");
            }

        }
        else{
            System.out.println("userName is null or context is not null");

        }

        filterChain.doFilter(request,response);


    }
}
