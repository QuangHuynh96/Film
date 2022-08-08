package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<Film> findAll();
    Page<Film> findAll(Pageable pageable);
//    Film save(Film film);
    Optional<Film> findById(Long id);
    void deleteById(Long id);
    Page<Film> searchByName(String name, Pageable pageable);

}
