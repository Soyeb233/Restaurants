package com.hotel.HotelService.GlobalException;

import com.hotel.HotelService.responseHandler.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> exceptionHandler(GlobalException globalException){
     return ResponseHandler.generateResponce(globalException.getHttpStatus() , false ,globalException.getMessage());
    }
}
