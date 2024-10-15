package com.rating.RatingService.service;

import com.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating createRating(Rating rating);

    // Get RatingById
    Rating getRating(int ratingId);

    // Get All Data from Db
    List<Rating> getAllRating();

    //get All by Rating Id
    List<Rating> getRatingByUserId(int userId);

    //get All by Hotel ID
    List<Rating> getRatingByHotelId(int hotelId);

    // update rating
    String updateRating(Rating rating,int ratingId);

    // delete rating
    String deleteRating(int ratingId);

}
