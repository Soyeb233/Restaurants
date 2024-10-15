package com.hotel.HotelService.service;

import com.hotel.HotelService.GlobalException.GlobalException;
import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class HotelServiceImple implements  HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        try {
            hotel.setDate(java.sql.Date.valueOf(LocalDate.now()));
          return  hotelRepository.save(hotel);
        }
        catch (Exception ex){
            throw new GlobalException("Records Not insered", HttpStatus.CONFLICT);
        }

    }

    @Override
    public List<Hotel> getAllHotel() {
        List<Hotel> hotelList;
        hotelList=hotelRepository.findAll();
        if(hotelList!=null){
            return hotelList;
        }
        throw new GlobalException("Hotel Data is Empty",HttpStatus.OK);
    }

    @Override
    public Hotel getHotel(int hotelId) {
        Optional<Hotel> hotel=hotelRepository.findById(hotelId);
        if(hotel.isPresent()){
            return hotel.get();
        }
        else{
            throw new GlobalException("Id not found..",HttpStatus.NOT_FOUND);
        }

    }
}
