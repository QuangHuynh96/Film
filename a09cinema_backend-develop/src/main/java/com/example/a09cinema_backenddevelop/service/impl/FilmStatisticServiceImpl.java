package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.DTO.StatisticFilm;
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
    public List<StatisticFilm> statisticalByCurrentDay() {
        return filmStatsticRepository.statisticalByCurrentDay();
    }

    @Override
    public String countNameFilm() {
        return filmStatsticRepository.countNameFilm();
    }

    @Override
    public String countTicket() {
        return filmStatsticRepository.countTicket();
    }

}
