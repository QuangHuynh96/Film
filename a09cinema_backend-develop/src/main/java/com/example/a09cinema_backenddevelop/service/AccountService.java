package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    Page<Account> getAllAccount(Pageable pageable);

    List<Account> findAll();

    void save(Account account);

    Account findById(long id);
}
