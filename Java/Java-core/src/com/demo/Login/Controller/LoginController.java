package com.demo.Login.Controller;

import com.demo.Login.Entity.Login;
import com.demo.Login.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        String result = loginService.authenticateUser(login);
        return ResponseEntity.ok(result);
    }
}
