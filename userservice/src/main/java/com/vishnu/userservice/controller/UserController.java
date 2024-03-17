package com.vishnu.userservice.controller;

import com.vishnu.userservice.entities.Hotel;
import com.vishnu.userservice.entities.Rating;
import com.vishnu.userservice.entities.User;
import com.vishnu.userservice.externalServices.HotelService;
import com.vishnu.userservice.externalServices.RatingService;
import com.vishnu.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    UserService userService;
    @Autowired
    RestTemplate resttemplate;

    @Autowired
    HotelService hotelService;
    @Autowired
    RatingService ratingService;
      @PostMapping
      ResponseEntity<User> createUser(@RequestBody User user){
       User user1 =  userService.saveUser(user);
       return new ResponseEntity<User>(user, HttpStatus.CREATED);
      }
      @GetMapping("/getUser/{userId}")
     ResponseEntity<User> getUser(@PathVariable String userId){

       User user =   userService.getUser(userId);
       Rating[] rating =   resttemplate.getForObject("http://RATINGSERVICE/rating/getRatingByUser/"+userId, Rating[].class);
      List<Rating> ratingList =    Arrays.stream(rating).toList();
          ratingList.stream().map(rating1 -> {
            ResponseEntity<Hotel> hotel =   resttemplate.getForEntity("http://HOTELSERVICE/hotel/getHotel/"+rating1.getHotelId(), Hotel.class);
              rating1.setHotel(hotel.getBody());
              return rating1;
          }).collect(Collectors.toList());
          user.setRatings(ratingList);
       return  new ResponseEntity<User>(user,HttpStatus.ACCEPTED);

      }


    @GetMapping("/getUserFeign/{userId}")
    ResponseEntity<User> getUserFeign(@PathVariable String userId){

        User user =   userService.getUser(userId);
        List<Rating> ratingList = ratingService.getRatings(userId);
        ratingList.stream().map(rating1 -> {
            rating1.setHotel(hotelService.getHotel(rating1.getHotelId()));
            return rating1;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return  new ResponseEntity<User>(user,HttpStatus.ACCEPTED);

    }

      @GetMapping("getAllUser")
      List<User> getAllUser(){
        return   userService.getAllUsers();
      }
}
