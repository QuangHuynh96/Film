package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "employee/list")
    public Page<Account> getAllEmployee(@PageableDefault(5)Pageable pageable, @RequestParam("search") Optional<String> search) {
        if (search.isPresent()) {
            return accountService.searchEmployee(pageable, search.get());
        }
        return accountService.listEmployee(pageable);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/list")
    public ResponseEntity<Page<Account>> getAllAccount(@RequestParam(defaultValue = "",name = "username") String key_username,
                                                       @PageableDefault(size = 10)Pageable pageable){

        Page<Account> accounts = accountService.getAllAccount(key_username, pageable);

        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(account,HttpStatus.OK);

    }

    @DeleteMapping(value = "employee/delete/{id}")
    public ResponseEntity<Account> deleteByEmployeeId(@PathVariable Long id) {
        accountService.deleteEmployeeAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Account> editAccount(@PathVariable Long id,
                                               @Valid
                                               @RequestBody Account account) {
        Account account1 = accountService.findById(id);
        if (account1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        account.setId(id);
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
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

//    @PostMapping("/auth/add")
//    public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account, BindingResult bindingResult) {
//        if (bindingResult.hasFieldErrors()) {
//            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//        if (accountService.existsByEmail(account.getEmail())) {
//            System.out.println("Email đã được đăng kí");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        if (accountService.existsByUsername(account.getUsername())){
//            System.out.println("Username đã đăng kí");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        }
//        String passWord = account.getPassword();
//        account.setPassword(passwordEncoder.encode(passWord));
//        Account newAccount = accountService.saveAccount(account);
//        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
//    }
}

