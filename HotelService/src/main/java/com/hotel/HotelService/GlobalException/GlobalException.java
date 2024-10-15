package com.hotel.HotelService.GlobalException;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
public class GlobalException extends RuntimeException{
    String message;
    HttpStatus httpStatus;
    public GlobalException(String message,HttpStatus httpStatus){
        super(message);
        this.message=message;
        this.httpStatus=httpStatus;
    }

}
