package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.DTO.StatisticFilm;

import java.util.List;

public interface FilmStatisticService {

    List<StatisticFilm> statisticalByCurrentDay();

    String countNameFilm();

    String countTicket();

}
