package com.hotel.HotelService.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String hotelName;
    private String hotelLocation;
    private String hotelAbout;
    private int hotelRating;
    private boolean hotelStatus;
    private Date date;
}
