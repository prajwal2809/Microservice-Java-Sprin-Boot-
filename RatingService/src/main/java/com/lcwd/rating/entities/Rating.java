package com.lcwd.rating.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Getter
@Setter
@Document("user_ratings")
public class Rating {

    @Id
    private int ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public String getUserId() {
        return userId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
