package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import  com.example.a09cinema_backenddevelop.service.AccountService;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired private AccountRepository accountRepository;


    @Override
    public Page<Account> searchEmployee(Pageable pageable, String s) {
        return accountRepository.getSearchAllEmployee(pageable,s);
    }

    @Override
    public Page<Account> listEmployee(Pageable pageable) {
        return accountRepository.getAllEmployee(pageable);
    }

    @Override
    public void deleteEmployeeAccountById(Long id) {
        accountRepository.deleteEmployeeAccountById(id);
    }



}
