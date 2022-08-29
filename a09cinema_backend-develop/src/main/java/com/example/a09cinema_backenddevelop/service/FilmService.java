package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {
    Page<Film> search(String value, Pageable pageable);
    Page<Film> findAll(Pageable pageable);
    Page<Film> findSort(Pageable pageable);
    Film findFilmById(long id);

}
