package com.demo.Service;

import com.demo.Entity.User;
import com.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public boolean authenticate(String username, String password) {
        User u = userRepo.findByUsernameAndPassword(username, password);
        return u != null;
    }
}
