package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/getbookedticket")
    public ResponseEntity<List> getBookedTicket() {
        List list = ticketService.getBookedTicket();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
