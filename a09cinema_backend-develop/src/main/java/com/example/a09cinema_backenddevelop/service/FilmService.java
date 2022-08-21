package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;

import java.util.List;

public interface FilmService {
    List<Film> findAllListFilm();
    Film findFilmByID(Long id);


}
