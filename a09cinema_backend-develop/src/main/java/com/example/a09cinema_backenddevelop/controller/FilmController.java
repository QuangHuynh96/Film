package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.repository.FilmRepository;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/film")
@CrossOrigin("*")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/info")
    public Film getInfoFilm(@RequestParam("id") long id) {
        Film filmInfo = this.filmService.findFilmById(id);
        return filmInfo;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Film>> search(String value, Pageable pageable) {
        Page<Film> films = filmService.search(value, pageable);
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Film>> findFilmWithPage(Pageable pageable) {
        Page<Film> films = filmService.findAll(pageable);
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<Page<Film>> findSortWithPage(Pageable pageable) {
        Page<Film> films = filmService.findSort(pageable);
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
}
