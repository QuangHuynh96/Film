package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.History;
import com.example.a09cinema_backenddevelop.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin("http://localhost:4200/")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    /*
        Nguyen Phuoc Dai Toan
        get list history point reward of user
    */
    @GetMapping("/view-point-reward")
    public ResponseEntity<List<History>> findHistoriesPointReward(
            @RequestParam Long accountId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        List<History> histories = historyService.findHistoriesPointReward(getLocalDateTime(start), getLocalDateTime(end),
                page * size, size, accountId);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    /*
        Nguyen Phuoc Dai Toan
        get list history point exchange of user
    */
    @GetMapping("/view-point-exchange")
    public ResponseEntity<List<History>> findHistoriesPointExchange(
            @RequestParam Long accountId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        List<History> histories = historyService.findHistoriesPointExchange(getLocalDateTime(start), getLocalDateTime(end),
                page * size, size, accountId);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    /*
        Nguyen Phuoc Dai Toan
        get total page point reward
    */
    @GetMapping("/total-page-reward")
    public ResponseEntity<Integer> findTotalPagePointReward(
            @RequestParam Long accountId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
            @RequestParam(defaultValue = "5") int size) {
        int totalPage = historyService.findTotalPointReward(getLocalDateTime(start), getLocalDateTime(end), accountId);
        if(totalPage % size == 0)       totalPage = totalPage / size;
        else totalPage = (int)Math.floor(totalPage * 1.0 / size) + 1;
        return new ResponseEntity<>(totalPage, HttpStatus.OK);
    }

    /*
        Nguyen Phuoc Dai Toan
        get total point exchange
    */
    @GetMapping("/total-page-exchange")
    public ResponseEntity<Integer> findTotalPagePointExchange(
            @RequestParam Long accountId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
            @RequestParam(defaultValue = "5") int size) {
        int totalPage = historyService.findTotalPointExchange(getLocalDateTime(start), getLocalDateTime(end), accountId);
        if(totalPage % size == 0)       totalPage = totalPage / size;
        else totalPage = (int)Math.floor(totalPage * 1.0 / size) + 1;
        return new ResponseEntity<>(totalPage, HttpStatus.OK);
    }

    /*
        Nguyen Phuoc Dai Toan
        Convert Date to LocalDateTime
     */
    private LocalDateTime getLocalDateTime(Date date) {
        return new Timestamp(date.getTime()).toLocalDateTime();
    }
}
