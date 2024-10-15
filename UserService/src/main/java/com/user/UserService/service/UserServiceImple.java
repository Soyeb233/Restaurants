package com.user.UserService.service;

import com.user.UserService.entities.User;
import com.user.UserService.globalException.ApiResponse;
import com.user.UserService.globalException.GlobalException;
import com.user.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements  UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try {
            user.setDate(java.sql.Date.valueOf(LocalDate.now()));
            userRepository.save(user);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new GlobalException("Records Not Saved..",HttpStatus.NOT_ACCEPTABLE);

        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList=null;

             userList = userRepository.findAll();
             if(userList==null)
             {
                 throw new GlobalException("List is Empty",HttpStatus.NOT_FOUND);
             }

      return userList;
    }

    @Override
    public User getUser( int userId) {
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new GlobalException("User Not present..",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public String deleteUser(int userId) {
         Optional<User> user=userRepository.findById(userId);
         if(user.isPresent()){
             user.get().setStatus(false);
             userRepository.save(user.get());
             return "Records Deleted Succesfully";
         }
         else{
             throw new GlobalException("User Not found",HttpStatus.NOT_FOUND);
         }

    }

    @Override
    public String updateUser(User user, int userId) {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isPresent()){
            User userData=userOptional.get();
            userData.setUserName(user.getUserName());
            userData.setUserEmail(user.getUserEmail());
            userData.setUserAbout(user.getUserAbout());
            userData.setStatus(user.isStatus());
            try {
                userRepository.save(userData);
                return "Records Updated Succesfullyy.....";
            }
            catch (Exception ex){
                throw new GlobalException("Records not updated",HttpStatus.NOT_ACCEPTABLE);
            }
        }
        else{
            throw new GlobalException("User Not Found..",HttpStatus.NOT_FOUND);
        }


    }
}
