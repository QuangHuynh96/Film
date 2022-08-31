package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import  com.example.a09cinema_backenddevelop.service.AccountService;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Page<Account> getAllAccount(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(long id) {
        return accountRepository.findAccountId(id);
    }

//    @Override
//    public void editMember(Account account) {
//        accountRepository.editMember(account.getId(), account.getFullname(), account.getPassword(), account.getBirthday(), account.getGender(), account.getEmail(), account.getPhone(), account.getAddress());
//    }

}
