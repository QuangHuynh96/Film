package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Film;

import java.util.List;

public interface FilmService {
    Film findFilmById(long id);

    List<Film> findAll();
}
