package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Booking;
import com.example.a09cinema_backenddevelop.repository.BookingRepository;
import com.example.a09cinema_backenddevelop.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }
}
