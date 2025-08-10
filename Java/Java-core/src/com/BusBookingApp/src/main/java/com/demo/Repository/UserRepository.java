package com.BusBookingApp.src.main.java.com.demo.Repository;

import com.demo.Model.User;

import java.util.List;

public interface UserRepository {

    String addUser(User user);
    User getUserById(String userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(String userId);
    boolean validateUser(String email, String password);
    String generateUserId();
}
