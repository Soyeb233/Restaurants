package com.rating.RatingService.globalException;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;
    public GlobalException(String message){
        super(message);
        this.message=message;
    }
    public GlobalException(String message,HttpStatus httpStatus){
        super(message);
        this.message=message;
        this.httpStatus=httpStatus;
    }

}

