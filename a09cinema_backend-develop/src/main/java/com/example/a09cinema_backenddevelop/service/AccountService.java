package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Account;


public interface AccountService {
    Account findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Account save(Account user);
}
