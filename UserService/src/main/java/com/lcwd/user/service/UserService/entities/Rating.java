package com.lcwd.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private  Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getUserId() {
        return userId;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getRatingId() {
        return ratingId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
