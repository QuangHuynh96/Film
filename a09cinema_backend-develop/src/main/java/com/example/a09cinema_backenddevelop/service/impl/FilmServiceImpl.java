package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.repository.FilmRepository;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film findById(Long id) {
        return filmRepository.findFilmById(id);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }
}
