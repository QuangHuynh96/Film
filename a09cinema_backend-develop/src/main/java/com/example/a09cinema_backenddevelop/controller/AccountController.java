package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping(value = "employee/list")
    public Page<Account> getAllEmployee(@PageableDefault(5)Pageable pageable, @RequestParam("search") Optional<String> search) {
        if(search.isPresent()){
            return accountService.searchEmployee(pageable,search.get());
        }
        return accountService.listEmployee(pageable);

    }
    @GetMapping("/employee/{id}")
    public Optional<Account> getEmployeeById(@PathVariable(value = "id") Long id) {
        return accountService.findEmployeeById(id);
    }

    @DeleteMapping(value = "employee/delete/{id}")
    public ResponseEntity<Account> deleteByEmployeeId(@PathVariable Long id) {
        accountService.deleteEmployeeAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
