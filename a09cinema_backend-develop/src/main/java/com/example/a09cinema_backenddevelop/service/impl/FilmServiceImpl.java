package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.CategoryFilm;
import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.repository.FilmRepository;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
        // lấy id film để thêm bảng trung gian category_film
        // for: list Category
    }

    @Override
    public Film findById(Long id) {
        return filmRepository.findFilmById(id);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public List<CategoryFilm> findAllCategoryFilm() {
        return filmRepository.findAllCategoryFilm();
    }

    @Override
    public void saveCategoryFilm(Long categoryId, Long filmId) {
        filmRepository.saveCategoryFilm(categoryId,filmId);
    }

    @Override
    public Long findFilmIdByName(String name) {
        return filmRepository.findFilmIdByName(name);
    }


}
