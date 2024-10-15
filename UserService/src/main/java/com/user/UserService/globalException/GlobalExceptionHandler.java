package com.user.UserService.globalException;

import com.user.UserService.responceHandler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(ApiResponse.class)
  public ResponseEntity<Object> handlerResourceNotFound(ApiResponse apiResponse){
     String message=apiResponse.getMessage();
      ApiResponse response= ApiResponse.builder().message(message).success(true).httpStatus(apiResponse.getHttpStatus()).build();
      return new ResponseEntity<Object>(response,apiResponse.getHttpStatus());
  }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> globalExceptionHandler(GlobalException globalException){
//        String message=globalException.getMessage();
//        GlobalException response= GlobalException.builder().message(message).httpStatus(globalException.getHttpStatus()).build();
//        return new ResponseEntity<Object>(response,globalException.getHttpStatus());
        return ResponseHandler.generateResponce(globalException.getHttpStatus() , false ,globalException.getMessage());
    }


}
