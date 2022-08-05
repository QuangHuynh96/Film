package com.example.a09cinema_backenddevelop.service.impl;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import com.example.a09cinema_backenddevelop.repository.ManagerBookingRepository;
import com.example.a09cinema_backenddevelop.service.ManagerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ManagerBookingServiceImpl implements ManagerBookingService {
    @Autowired
    private ManagerBookingRepository repository;

    @Override
    public Page<Booking> findAll(String key, Pageable pageable) {
        return repository.findAll(key, pageable);
    }

    @Override
    public Booking findBookingById(Long id) {
        return repository.findBookingById(id);
    }

//    @Override
//    public void takeTicket(Booking booking) {
//            repository.takeTicket(booking.getId());
//
//    }

    @Override
    public Optional<Booking> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Booking booking) {
        repository.save(booking);
    }
}
