package com.app.firstSpringApp.service;

import org.springframework.stereotype.Component;

@Component
public class Department {

    public String getDepartmentName() {
        return "Computer Science Department";
    }
}