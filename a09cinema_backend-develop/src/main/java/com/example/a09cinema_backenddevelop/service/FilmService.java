package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FilmService {
    Page<Film> findAll(Pageable pageable);
    Optional<Film> findById(Long id);
    void deleteById(Long id);
    Page<Film> search(String value, Pageable pageable);
}
