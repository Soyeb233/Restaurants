package com.user.UserService.service;

import com.user.UserService.entities.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUser();
    public User getUser(int userId);
    public String deleteUser(int userId);
    public String updateUser(User user,int userId);

}
