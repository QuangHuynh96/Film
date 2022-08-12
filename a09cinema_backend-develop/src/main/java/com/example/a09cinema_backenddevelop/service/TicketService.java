package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.BookedTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Page<BookedTicket> getBookedTicket(Pageable pageable);
}
