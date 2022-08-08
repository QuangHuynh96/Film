package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<Page<Account>> getAllAccount(@RequestParam(defaultValue = "")
                                                           @PageableDefault(size = 10)Pageable pageable,
                                                       Model model){
        Page<Account> accounts = accountService.getAllAccount(pageable);
        model.addAttribute("accounts", accounts);
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Account> showEdit(@PathVariable long id){
       // model.addAttribute("account", accountService.findById(id));
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PatchMapping("/edit")
    public ResponseEntity<Account> edit(Account account){
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Account>> findAllAccount() {
//        List<Account> accounts = (List<Account>) accountService.findAll();
//        if (accounts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(accounts, HttpStatus.OK);
//    }
}
