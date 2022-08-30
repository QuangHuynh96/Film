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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<Page<Account>> getAllAccount( @PageableDefault(size = 10)Pageable pageable){

        Page<Account> accounts = accountService.getAllAccount(pageable);

        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Account> editAccount(@PathVariable Long id,
                                               @Valid
                                               @RequestBody Account account) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        account.setId(accountOptional.get().getId());
//        accountService.editMember(account);
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
        }
    }

//    @PostMapping("/edit")
//    public ResponseEntity<Account> save(@RequestParam Long id, @Valid @RequestBody Account account){
//        if (accountService.findById(id) == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        account.setId(id);
//        accountService.editMember(account);
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }

//    @GetMapping("/edit/{id}")
//    public ResponseEntity<Account> showEdit(@PathVariable long id){
//       // model.addAttribute("account", accountService.findById(id));
//        return ResponseEntity.ok(accountService.findById(id));
//    }

//
//    @PatchMapping("/edit")
//    public ResponseEntity<Account> edit(Account account){
//        accountService.save(account);
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Account>> findAllAccount() {
//        List<Account> accounts = (List<Account>) accountService.findAll();
//        if (accounts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(accounts, HttpStatus.OK);
//    }
