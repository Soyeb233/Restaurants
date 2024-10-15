package com.hotel.HotelService.service;

import com.hotel.HotelService.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {
    // create HOTEL
    Hotel createHotel(Hotel hotel);
    //getAll HOTEL
    List<Hotel> getAllHotel();
    //Get Hotel By ID
    Hotel getHotel(int hotelId);
}
