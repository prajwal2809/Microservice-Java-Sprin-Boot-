package com.lcwd.user.service.UserService.external.services;

import com.lcwd.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Objects;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @PostMapping("/ratings/")
    public Rating createRating(@RequestBody  Rating rating);

    @PostMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId,Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public  void deleteRating(@PathVariable("ratingId") String ratingId);
}
