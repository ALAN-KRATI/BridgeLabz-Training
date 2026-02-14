package com.app.firstSpringApp.controller;

import com.app.firstSpringApp.service.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private Employee employee;

    @GetMapping("/employee")
    public String showEmployee() {
        return employee.getEmployeeInfo();
    }
}