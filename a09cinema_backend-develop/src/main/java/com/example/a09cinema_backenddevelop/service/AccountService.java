package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface AccountService {
    Page<Account> listEmployee(Pageable pageable);
    Page<Account> searchEmployee(Pageable pageable,String search);

    void deleteEmployeeAccountById(Long id);

    Optional<Account> findEmployeeById(Long id);

    Account save(Optional<Account> accountOptional);


//    Object updateEmployee(long id, Account account);
}
