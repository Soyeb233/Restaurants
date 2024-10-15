package com.user.UserService.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rating {
    private int ratingId;
    private int userId;
    private int hotelId;
    private int rating;
    private String feedback;
}
