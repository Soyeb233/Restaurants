package com.rating.RatingService.controller;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.responseHandler.ResponseHandler;
import com.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratingService")
public class RatingServiceController {
    @Autowired
    private RatingService ratingService;

    // create
    @PostMapping("/createRating")
    public ResponseEntity<Object> createRating(@RequestBody Rating rating){
        return ResponseHandler.generateResponce(HttpStatus.CREATED,true,ratingService.createRating(rating));
    }
    @GetMapping("/getRatingById/{ratingId}")
    public ResponseEntity<Object> getRatingById(@PathVariable int ratingId){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,ratingService.getRating(ratingId));
    }
    @GetMapping("/getAllRating")
    public ResponseEntity<Object>  getAllRating(){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,ratingService.getAllRating());
    }
    @GetMapping("/getRatingByUserId/{userId}")
    public ResponseEntity<Object> getRatingByUserId(@PathVariable int userId){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,ratingService.getRatingByUserId(userId));
    }
    @GetMapping("/getRatingByHotelId/{hotelId}")
    public ResponseEntity<Object> getRatingByHotelId(@PathVariable int hotelId){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,ratingService.getRatingByHotelId(hotelId));
    }
}
