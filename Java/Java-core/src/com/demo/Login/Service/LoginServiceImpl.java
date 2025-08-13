package com.demo.Login.Service;

import com.demo.Login.Entity.Login;
import com.demo.Login.Entity.User;
import com.demo.Login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String authenticateUser(Login login) {
        Optional<User> user = userRepository.findByUsernameAndPassword(
                login.getUsername(), login.getPassword());

        if (user.isPresent()) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
