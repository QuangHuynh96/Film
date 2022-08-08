package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.service.AccountStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountStatisticController {

    @Autowired
    private AccountStatisticService accountStatisticService;

    @GetMapping("/api/statistic/account")
    public ResponseEntity accounrStatistic() {

        List<?> accounts = accountStatisticService.statisticalByAccount();
        if (accounts.isEmpty()) {
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
