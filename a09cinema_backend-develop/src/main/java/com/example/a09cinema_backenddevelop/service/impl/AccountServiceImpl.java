package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import  com.example.a09cinema_backenddevelop.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    /*
        Nguyen Phuoc Dai Toan: find account by id
    */
    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    /*
        Nguyen Phuoc Dai Toan: update password
    */
    @Modifying
    @Override
    public void updatePassword(Long id, String newPassword) {
        accountRepository.updatePassword(id, newPassword);
    }

    /*
        Nguyen Phuoc Dai Toan: create + update account
    */
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

}
