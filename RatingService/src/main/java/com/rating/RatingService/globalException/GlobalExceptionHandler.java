package com.rating.RatingService.globalException;

import com.rating.RatingService.responseHandler.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> globalExceptionHandler(GlobalException globalException){
//        String message=globalException.getMessage();
//        GlobalException response= GlobalException.builder().message(message).httpStatus(globalException.getHttpStatus()).build();
//        return new ResponseEntity<Object>(response,globalException.getHttpStatus());
        return ResponseHandler.generateResponce(globalException.getHttpStatus() , false ,globalException.getMessage());
    }
}
