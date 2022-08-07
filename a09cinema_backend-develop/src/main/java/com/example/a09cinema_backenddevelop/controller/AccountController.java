package com.example.a09cinema_backenddevelop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @PostMapping("/create")
    public String firstPage() {
        return "Hello World";
    }
}
