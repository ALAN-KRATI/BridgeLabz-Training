package com.app.firstSpringApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloMvcController {

    @GetMapping("/hello-page")
    public String hello(Model model) {

        model.addAttribute("message", "Hello from BridgeLabz");

        return "hello";
    }
}