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
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping("/updatePassword")
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Account> save(@RequestParam Long id, @Valid @RequestBody Account accountRequest) {
        if (accountService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        accountRequest.setId(id);
        accountService.updateInfo(accountRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public String firstPage() {
        return "Hello World";
    }
}
