package com.hotel.HotelService.controller;

import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.responseHandler.ResponseHandler;
import com.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotelService")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/createHotel")
    public ResponseEntity<Object> createHotel(@RequestBody Hotel hotel){
        return ResponseHandler.generateResponce(HttpStatus.CREATED,true,hotelService.createHotel(hotel));
    }
    @GetMapping("/getHotelById/{hotelId}")
    public ResponseEntity<Object> getHotelById(@PathVariable int hotelId){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,hotelService.getHotel(hotelId));
    }
    @GetMapping("/getAllHotel")
    public ResponseEntity<Object> getAllHotel(){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,hotelService.getAllHotel());

    }

}
