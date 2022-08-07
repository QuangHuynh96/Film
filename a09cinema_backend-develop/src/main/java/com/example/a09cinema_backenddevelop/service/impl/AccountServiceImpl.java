package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import com.example.a09cinema_backenddevelop.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Modifying
    @Override
    public void updatePassword(Long id, String newPassword) {
        accountRepository.updatePassword(id, newPassword);
    }

    @Override
    public void updateInfo(Account ac) {
        accountRepository.updateInfo(ac.getId(), ac.getFullname(), ac.getBirthday(),
                ac.getGender(), ac.getEmail(), ac.getIdCard(), ac.getPhone(), ac.getAddress());
    }
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
