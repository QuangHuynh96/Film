package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;
import com.example.a09cinema_backenddevelop.repository.SeatDetailRepository;
import com.example.a09cinema_backenddevelop.service.SeatDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatDetailServiceImpl implements SeatDetailService {
    @Autowired
    private SeatDetailRepository seatDetailRepository;
    @Override
    public List<SeatDetail> findAll() {
        return seatDetailRepository.findAll();
    }
}
