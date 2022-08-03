package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
        Nguyen Phuoc Dai Toan
        user update password
    */
    @PutMapping("/updatePassword")
    public ResponseEntity<Account> updatePassword(@RequestParam Long id,
                                                  @RequestParam String oldPass,
                                                  @RequestParam String newPass) {
        Account account = accountService.findById(id);

        if(account == null) {
            System.out.println("account không tồn tại");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // If old password = password in database
        if(passwordEncoder.matches(oldPass, account.getPassword())) {
            System.out.println("password hợp lệ");
            account.setPassword(passwordEncoder.encode(newPass));
            accountService.updatePassword(id, account.getPassword());
        }
        else {
            System.out.println("password không hợp lệ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    /*
        Nguyen Phuoc Dai Toan
        user update information account as fullName, birthday,...
    */
    @PutMapping("/update/{id}")
    public ResponseEntity<Account> save(@PathVariable Long id, @Valid @RequestBody Account accountRequest) {
        if(accountService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        accountRequest.setId(id);
        return new ResponseEntity<>(accountService.save(accountRequest), HttpStatus.OK);
    }
}
