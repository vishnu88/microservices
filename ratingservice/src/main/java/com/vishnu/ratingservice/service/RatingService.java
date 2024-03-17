package com.vishnu.ratingservice.service;

import com.vishnu.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getAllRating();
    List<Rating> getRatingByHotelId(String hotelId);

    List<Rating> getRatingByUserid(String userid);

    Rating createRating(Rating rating);

}
