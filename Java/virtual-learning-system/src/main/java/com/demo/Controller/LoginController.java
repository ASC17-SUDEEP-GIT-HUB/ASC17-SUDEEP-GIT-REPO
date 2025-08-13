package com.demo.Controller;

import com.demo.Entity.Login;
import com.demo.Entity.User;
import com.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return loginService.registerUser(user);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody Login login) {
        return loginService.authenticate(login.getUsername(), login.getPassword())
                ? "Login Successful"
                : "Invalid Credentials";
    }

}
