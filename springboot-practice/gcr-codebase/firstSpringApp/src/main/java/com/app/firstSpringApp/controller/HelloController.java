package com.app.firstSpringApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // @GetMapping("/hello")
    // public String hello() {
    //     return "Hello Spring Boot! 🎉";
    // }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name + " 👋 Welcome to Spring Boot!";
    }
}