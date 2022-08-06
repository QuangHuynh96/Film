package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        String passWord=account.getPassword();
        account.setPassword(passwordEncoder.encode(passWord));
        Account newAccount=accountService.saveAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
}
