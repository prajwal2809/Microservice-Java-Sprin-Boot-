package com.lcwd.rating.repository;

import com.lcwd.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, Integer> {

    //custom methods

    List<Rating> findByUserId(String  userId);
    List<Rating> findByHotelId(String hotelId);
}
