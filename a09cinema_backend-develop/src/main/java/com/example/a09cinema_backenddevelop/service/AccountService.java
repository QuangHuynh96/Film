package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Account;

public interface AccountService {
    /*
        Nguyen Phuoc Dai Toan: get account by id
    */
    Account findById(Long id);
    /*
        Nguyen Phuoc Dai Toan: update password
    */
    void updatePassword(Long id, String newPassword);
    /*
        Nguyen Phuoc Dai Toan: create + update account
    */
    Account save(Account account);
}
