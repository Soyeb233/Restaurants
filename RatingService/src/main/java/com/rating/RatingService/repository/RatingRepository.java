package com.rating.RatingService.repository;

import com.rating.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {
    public List<Rating> findByHotelId(int hotelId);
    public List<Rating> findByUserId(int userId);
}
