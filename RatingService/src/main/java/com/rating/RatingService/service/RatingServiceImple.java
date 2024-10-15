package com.rating.RatingService.service;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.globalException.GlobalException;
import com.rating.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImple implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        try {
            return ratingRepository.save(rating);
        }
        catch (Exception ex){
            throw new GlobalException("Data not saved..",HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @Override
    public Rating getRating(int ratingId) {
        Optional<Rating> rating=ratingRepository.findById(ratingId);
        if(rating.isPresent()){
            return rating.get();
        }
        else{
            throw new GlobalException("Id not found..", HttpStatus.NOT_FOUND);
        }


    }

    @Override
    public List<Rating> getAllRating() {
        List<Rating> ratingList=ratingRepository.findAll();
        if(ratingList!=null){
            return ratingList;
        }
        else{
            throw new GlobalException("List is empty",HttpStatus.OK);
        }


    }

    @Override
    public List<Rating> getRatingByUserId(int userId) {
        List<Rating> ratingList=ratingRepository.findByUserId(userId);
        if(ratingList!=null){
            return ratingList;
        }
        else{
            throw new GlobalException("Records Not Found",HttpStatus.OK);
        }
    }

    @Override
    public List<Rating> getRatingByHotelId(int hotelId) {
        List<Rating> ratingList=ratingRepository.findByHotelId(hotelId);
        if(ratingList!=null){
            return ratingList;
        }
        else{
            throw new GlobalException("Records Not Found",HttpStatus.OK);
        }

    }

    @Override
    public String updateRating(Rating rating, int ratingId) {
        return null;
    }

    @Override
    public String deleteRating(int ratingId) {
        return null;
    }
}
