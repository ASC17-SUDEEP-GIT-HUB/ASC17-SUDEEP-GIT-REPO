package com.demo.Login.Service;

import com.demo.Login.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    Optional<User> findByUsername(String username);
}
