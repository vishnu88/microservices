package com.vishnu.hotelservice.HotelController;

import com.vishnu.hotelservice.entity.Hotel;
import com.vishnu.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")

public class HotelController {
    @Autowired
    HotelService hotelService;
    @PostMapping
    ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.ACCEPTED);
    }
    @GetMapping("getAllHotels")
    ResponseEntity<List<Hotel>> getAllHotels(){
      List<Hotel> hotels = hotelService.getAllHotel();
      return new ResponseEntity<List<Hotel>>(hotels,HttpStatus.ACCEPTED);
    }

    @GetMapping("getHotel/{hotelId}")
    ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);
        return new ResponseEntity<Hotel>(hotel,HttpStatus.ACCEPTED);
    }

}
