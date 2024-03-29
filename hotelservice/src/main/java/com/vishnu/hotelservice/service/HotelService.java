package com.vishnu.hotelservice.service;

import com.vishnu.hotelservice.entity.Course;
import com.vishnu.hotelservice.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    public Hotel getHotel(String id);
    public Hotel addHotel(Hotel hotel);
    public List<Hotel> getAllHotel();
}
