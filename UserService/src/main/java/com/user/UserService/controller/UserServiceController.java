package com.user.UserService.controller;

import com.user.UserService.entities.User;
import com.user.UserService.responceHandler.ResponseHandler;
import com.user.UserService.service.UserService;
import com.user.UserService.service.UserServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userService")
public class UserServiceController {
    @Autowired
    private UserService userService;
    // Create user
    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        return ResponseHandler.generateResponce(HttpStatus.CREATED,true,userService.saveUser(user));
    }

    //Get User By Id

    @GetMapping("userId/{id}")
    public Object get(@PathVariable int id){
        System.out.println(id);
        return "Hii";
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable int userId){
        User user=userService.getUser(userId);
        return  ResponseHandler.generateResponce(HttpStatus.OK , true ,userService.getUser(userId));
    }

    // GET ALL USER
    @GetMapping("/getAlluser")
    public ResponseEntity<Object> getAllUser(){
        return ResponseHandler.generateResponce(HttpStatus.OK,true,userService.getAllUser());
    }
    // DELETE USER
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Object> deleteuser(@PathVariable int userId){
        return ResponseHandler.generateResponce(HttpStatus.ACCEPTED,true,userService.deleteUser(userId));
    }
    // UPDATE USER
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int userId){
        return ResponseHandler.generateResponce(HttpStatus.ACCEPTED,true,userService.updateUser(user,userId));
    }


}
