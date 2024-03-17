package com.vishnu.ratingservice.service.impl;

import com.vishnu.ratingservice.entities.Rating;
import com.vishnu.ratingservice.repository.RatingRepository;
import com.vishnu.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public  List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public  List<Rating> getRatingByUserid(String userid) {
        return ratingRepository.findByUserId(userid);
    }

    @Override
    public Rating createRating(Rating rating) {
        String randomId = UUID.randomUUID().toString();
        rating.setId(randomId);
        return ratingRepository.save(rating);
    }
}
