package com.vishnu.userservice.externalServices;


import com.vishnu.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("hotel/getHotel/{hotelId}")
     Hotel getHotel(@PathVariable String hotelId);
}
