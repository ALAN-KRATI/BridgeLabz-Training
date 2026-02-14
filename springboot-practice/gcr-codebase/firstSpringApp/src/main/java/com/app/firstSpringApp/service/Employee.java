package com.app.firstSpringApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    private Department department;

    public String getEmployeeInfo() {
        return "Employee belongs to " + department.getDepartmentName();
    }
}