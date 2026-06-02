package com.employees.leavetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping
    public String ping(){
        return "Backend is running smooth very good";
    }
}
