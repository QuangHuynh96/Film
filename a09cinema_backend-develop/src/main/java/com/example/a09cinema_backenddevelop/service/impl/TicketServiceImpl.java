package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import com.example.a09cinema_backenddevelop.repository.TicketRepository;
import com.example.a09cinema_backenddevelop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
