package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Page<Film> getAllByNameContaining(String name, Pageable pageable);
}
