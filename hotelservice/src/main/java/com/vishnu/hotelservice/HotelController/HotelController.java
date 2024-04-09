package com.vishnu.hotelservice.HotelController;

import com.vishnu.hotelservice.entity.Course;
import com.vishnu.hotelservice.entity.Hotel;
import com.vishnu.hotelservice.service.CourseService;
import com.vishnu.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")

public class HotelController {
    @Autowired
    private ServletWebServerApplicationContext server;
    @Autowired
    HotelService hotelService;
    @Autowired
    CourseService courseService;
    @PostMapping
    ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addCourse")
    ResponseEntity<Course> addCourse(@RequestBody Course course){

        courseService.addCourses(course);

         return new ResponseEntity<>(course,HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getAllCources")
    ResponseEntity<List<Course>> getAllCources(){
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<List<Course>>(courses,HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteCourse/{id}")
    ResponseEntity<String> deleteCourse(@PathVariable String id){

        courseService.deleteCourse(id);

        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
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

    @GetMapping("bio/{hotelId}")
    ResponseEntity<String> getBioTestLoadBalancing(@PathVariable String hotelId){
//        System.out.println("*********" + server.getWebServer().getPort());
        return new ResponseEntity<String>(hotelId,HttpStatus.ACCEPTED);
    }
}
