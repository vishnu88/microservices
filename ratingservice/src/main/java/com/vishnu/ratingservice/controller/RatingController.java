package com.vishnu.ratingservice.controller;

import com.vishnu.ratingservice.entities.Rating;
import com.vishnu.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;
    @PostMapping
   ResponseEntity<Rating> createRating(@RequestBody Rating rating){
          Rating rating2 = ratingService.createRating(rating);
           return new ResponseEntity<Rating>(rating2, HttpStatus.CREATED);
   }
   @GetMapping("/getAllRatings")
   ResponseEntity<List<Rating>>   getAllRating(){

        List<Rating> ratings = ratingService.getAllRating();
        return new ResponseEntity<List<Rating>>(ratings,HttpStatus.ACCEPTED);
   }

    @GetMapping("/getRatingName")
    ResponseEntity<String>   getRatingName(){
        return new ResponseEntity<String>("This is static data",HttpStatus.ACCEPTED);
    }

   @GetMapping("/getRatingByHotel/{hotelId}")
   ResponseEntity<List<Rating>>   getRatingByHotelId(@PathVariable String hotelId){

        List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<List<Rating>>(ratings,HttpStatus.ACCEPTED);
   }

   @GetMapping("/getRatingByUser/{userId}")
   ResponseEntity<List<Rating>>   getRatingByUserId(@PathVariable String userId){

        List<Rating> ratings = ratingService.getRatingByUserid(userId);
        return new ResponseEntity<List<Rating>>(ratings,HttpStatus.ACCEPTED);
   }

}
