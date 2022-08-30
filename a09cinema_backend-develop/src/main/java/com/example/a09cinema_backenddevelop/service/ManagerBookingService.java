package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.dto.SelectAllBookingDto;
import com.example.a09cinema_backenddevelop.model.dto.SelectBookingDetail;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ManagerBookingService {
    Page<SelectAllBookingDto> findAll(String key, Pageable pageable);
    //    Booking findBookingById(Long id);
//Booking findBookingByBookingCode(String code);
    Optional<Booking> getById(Long id);
    void save(Booking booking);
    Optional<SelectBookingDetail> selectBookingDetail(Long id);
}
