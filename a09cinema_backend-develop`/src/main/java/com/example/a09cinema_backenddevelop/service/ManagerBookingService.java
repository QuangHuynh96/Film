package com.example.a09cinema_backenddevelop.service;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ManagerBookingService {
    Page<Booking> findAll(String key, Pageable pageable);
    Booking findBookingById(Long id);
//    void takeTicket(Booking booking);
    Optional<Booking> getById(Long id);
    void save(Booking booking);
}
