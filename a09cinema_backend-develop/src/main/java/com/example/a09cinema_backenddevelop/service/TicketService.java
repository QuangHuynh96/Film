package com.example.a09cinema_backenddevelop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Page getBookedTicket(Pageable pageable);
}
