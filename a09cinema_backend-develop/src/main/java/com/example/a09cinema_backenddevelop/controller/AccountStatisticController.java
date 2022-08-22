package com.example.a09cinema_backenddevelop.controller;



import com.example.a09cinema_backenddevelop.DTO.StatisticAccount;;
import com.example.a09cinema_backenddevelop.service.AccountStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/accountStatisticPage")
    public ResponseEntity<Page<StatisticAccount>> filmStatisticPage(@PageableDefault(size = 5) Pageable pageable)  {

        Page<StatisticAccount> StatisticAccounts = accountStatisticService.findAllAndPage(pageable);
        return new ResponseEntity<>(StatisticAccounts, HttpStatus.OK);

    }

    @GetMapping("/limitFiveNameAccount")
    public ResponseEntity<List<StatisticAccount>> limitFiveNameAccount()  {
        List<StatisticAccount> limitFiveAccount= accountStatisticService.limitFiveNameAccount();
        return new ResponseEntity<>(limitFiveAccount, HttpStatus.OK);
    }
}
