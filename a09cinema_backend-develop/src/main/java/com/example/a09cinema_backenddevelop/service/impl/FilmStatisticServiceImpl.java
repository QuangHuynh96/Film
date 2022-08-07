package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import com.example.a09cinema_backenddevelop.repository.FilmStatsticRepository;
import com.example.a09cinema_backenddevelop.service.FilmStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmStatisticServiceImpl implements FilmStatisticService {

    @Autowired
    private FilmStatsticRepository filmStatsticRepository;


    @Override
    public List<?> statisticalByCurrentDay() {
        return filmStatsticRepository.statisticalByCurrentDay();
    }
}
