package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.service.CategoryService;
import com.example.a09cinema_backenddevelop.service.FilmImgService;
import com.example.a09cinema_backenddevelop.service.FilmService;
import com.example.a09cinema_backenddevelop.service.SeatDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
@CrossOrigin(origins = "*")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmImgService filmImgService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SeatDetailService seatDetailService;

    @GetMapping("")
    public ResponseEntity<List<Film>> findAllFilm() {
        List<Film> filmList = filmService.findAll();
        if (filmList.isEmpty()) {
            return new ResponseEntity<List<Film>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Film>>(filmList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Film> saveFilm(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.save(film), HttpStatus.CREATED);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Film film1 = filmService.findById(id);
        if (film1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        film.setId(film1.getId());
        return new ResponseEntity<>(filmService.save(film), HttpStatus.OK);
    }
}
