package com.user.UserService.globalException;

import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse extends RuntimeException{
    private String message;
    private boolean success;
    private HttpStatus httpStatus;
}
