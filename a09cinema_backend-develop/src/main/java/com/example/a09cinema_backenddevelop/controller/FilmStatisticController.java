package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import com.example.a09cinema_backenddevelop.service.FilmStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FilmStatisticController {

    @Autowired
    private FilmStatisticService filmStatisticService;

    @GetMapping("/api/statistic/film")
    public ResponseEntity<?> filmStatistic() {

        List<?> tickets = filmStatisticService.statisticalByCurrentDay();
        if (tickets.isEmpty()) {
            return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
