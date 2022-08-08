package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.repository.TicketRepository;
import com.example.a09cinema_backenddevelop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public List getBookedTicket() {
        return ticketRepository.getBookedTicket();
    }
}
