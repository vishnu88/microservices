package com.vishnu.hotelservice.service;

import com.vishnu.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel getHotel(String id);
    public Hotel addHotel(Hotel hotel);
    public List<Hotel> getAllHotel();

}
