package com.BusBookingApp.src.main.java.com.demo.Service;

import com.demo.Model.User;
import com.BusBookingApp.src.main.java.com.demo.Repository.UserRepository;
import com.BusBookingApp.src.main.java.com.demo.Repository.UserRepositoryImpl;

import java.util.List;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[0-9]{10}$");

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public String registerUser(User user) {
        if (user == null || !validateUserData(user)) {
            return null;
        }

        // Check if email already exists
        User existingUser = userRepository.getUserByEmail(user.getEmail());
        if (existingUser != null) {
            System.out.println("User with email " + user.getEmail() + " already exists");
            return null;
        }

        return userRepository.addUser(user);
    }

    @Override
    public User getUserById(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            return null;
        }
        return userRepository.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null || user.getUserId() == null || !validateUserData(user)) {
            return false;
        }
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            return false;
        }
        return userRepository.deleteUser(userId);
    }

    @Override
    public boolean loginUser(String email, String password) {
        if (email == null || password == null ||
                email.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        return userRepository.validateUser(email, password);
    }

    @Override
    public boolean validateUserData(User user) {
        return user.getUserName() != null && !user.getUserName().trim().isEmpty() &&
                user.getEmail() != null && EMAIL_PATTERN.matcher(user.getEmail()).matches() &&
                user.getPhoneNumber() != null && PHONE_PATTERN.matcher(user.getPhoneNumber()).matches() &&
                user.getPassword() != null && user.getPassword().length() >= 6;
    }
}