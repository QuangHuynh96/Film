package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.repository.FilmRepository;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Page<Film> findAll(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    @Override
    public Page<Film> search(String value, Pageable pageable) {
        return filmRepository.search(value, value, pageable);
    }

//    @Override
//    public Page<Film> findSort(Pageable pageable) { return filmRepository.findSort(pageable);}
}
