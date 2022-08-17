package com.example.a09cinema_backenddevelop.controller;



import com.example.a09cinema_backenddevelop.DTO.StatisticAccount;
import com.example.a09cinema_backenddevelop.service.AccountStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@CrossOrigin("*")
@RequestMapping("/api/statistic/")
public class AccountStatisticController {

    @Autowired
    private AccountStatisticService accountStatisticService;

    @GetMapping("/account")
    public ResponseEntity<List<StatisticAccount>> accountStatistic() {

        List<StatisticAccount> statisticAccount = accountStatisticService.statisticalByAccountDay();
        if (statisticAccount.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<StatisticAccount>>(statisticAccount, HttpStatus.OK);
    }

//    public ResponseEntity accouncStatistic() {
//        List<StatisticAccount> statisticAccounts = this.accountStatisticService.statisticalByAccountDay();
//        return statisticAccounts.isEmpty() ?
//                new ResponseEntity(HttpStatus.NO_CONTENT) :
//                new ResponseEntity(statisticAccounts, HttpStatus.OK);
//    }
}
