package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
//    List<Film> findAll();
//    Pageable findAllByNameContaining(String name, Pageable pageable);
   Page<Film> findAll(Pageable pageable);
    Page<Film> findAllByNameContaining(String name, Pageable pageable);
}
