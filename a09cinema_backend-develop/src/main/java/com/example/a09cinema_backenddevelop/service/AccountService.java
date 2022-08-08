package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Account;

public interface AccountService {
    Account findById(Long id);
    void updatePassword(Long id, String newPassword);
    void updateInfo(Account account);
    Account findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Account save(Account account);
    Account saveAccount(Account account);
}
