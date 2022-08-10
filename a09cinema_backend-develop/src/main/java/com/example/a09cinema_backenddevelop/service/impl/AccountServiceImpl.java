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
    public Page<Account> listEmployee(Pageable pageable) {
        return accountRepository.getAllEmployee(pageable);
    }

    @Override
    public Page<Account> searchEmployee(Pageable pageable,String search) {
        return accountRepository.getSearchAllEmployee(pageable,search);
    }
    @Override
    public void deleteEmployeeAccountById(Long id) {
        accountRepository.deleteEmployeeAccountById(id);
    }

    @Override
    public Optional<Account> findEmployeeById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Optional<Account>  account) {
        Account account1= account.get();
        accountRepository.save(account1);
        return account1;
    }


}
