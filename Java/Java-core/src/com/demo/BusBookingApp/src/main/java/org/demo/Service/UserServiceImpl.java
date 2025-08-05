package org.demo.Service;

import org.demo.Model.User;
import org.demo.Repository.UserRepository;
import org.demo.Repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor injection
    public UserServiceImpl(UserRepository userRepository) {
       // this.userRepository = userRepository;
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean registerUser(User user) {
        // Check if user already exists
        if (userRepository.getUserByEmail(user.getEmail()) != null) {
            return false; // User already exists
        }
        userRepository.addUser(user);
        return true;
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }

    @Override
    public User getProfile(String userId) {
        return userRepository.getUserById(userId);
    }
}