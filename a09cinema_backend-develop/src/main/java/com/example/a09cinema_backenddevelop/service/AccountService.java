package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Page<Account> getAllAccount(Pageable pageable);

    List<Account> findAll();

    Account save(Account account);

    Optional<Account> findById(long id);

//    void editMember(Account account);
}
