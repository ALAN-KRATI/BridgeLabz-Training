package com.app.firstSpringApp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if(username.equals("admin") && password.equals("1234")) {
            return "Login Successful 🎉 Welcome " + username;
        }
        else {
            return "Invalid Username or Password ❌";
        }
    }
}