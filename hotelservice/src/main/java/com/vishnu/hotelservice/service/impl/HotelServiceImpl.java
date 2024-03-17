package com.vishnu.hotelservice.service.impl;

import com.vishnu.hotelservice.entity.Hotel;
import com.vishnu.hotelservice.exception.ResourceNotFoundException;
import com.vishnu.hotelservice.repository.HotelRepository;
import com.vishnu.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
       return hotelRepository.save(hotel);

    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }
}
