package com.vishnu.userservice.externalServices;

import com.vishnu.userservice.entities.Hotel;
import com.vishnu.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATINGSERVICE")
public interface RatingService {

    @GetMapping("rating/getRatingByUser/{userid}")
    List<Rating> getRatings(@PathVariable String userid);
}
