package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthController {

    @Value("${user.role}")
    private String role;

    @Value(("${spring.jpa.database}"))
    private String database;

    @GetMapping("/config")
    public String testConfig() {
        return String.format("You are %s %s" , role, database);
    }
}
