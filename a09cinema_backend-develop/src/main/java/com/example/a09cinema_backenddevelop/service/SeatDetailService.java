package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.dto.SeatDetailDto;
import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;

import java.util.List;

public interface SeatDetailService {
    List<SeatDetail> getAllSeatDetailByIdFilm(Long id);
    SeatDetailDto getIdSeatDetailByBookingCondition(String name, String date_show, long time_show_id);
}
