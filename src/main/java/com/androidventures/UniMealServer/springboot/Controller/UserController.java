package com.androidventures.UniMealServer.springboot.Controller;

import com.androidventures.UniMealServer.springboot.models.User;
import com.androidventures.UniMealServer.springboot.service.JWTservice;
import com.androidventures.UniMealServer.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userservice;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTservice jwt;

    @PostMapping("register")
    public User register(@RequestBody User user) {

        return userservice.save(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwt.generateToken(user.getUsername());
        } else {
            return "error login failed";
        }
    }
}
