package com.BusBookingApp.src.main.java.com.demo.Service;

import com.demo.Model.User;

import java.util.List;

public interface UserService {
    String registerUser(User user);
    User getUserById(String userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(String userId);
    boolean loginUser(String email, String password);
    boolean validateUserData(User user);
}
