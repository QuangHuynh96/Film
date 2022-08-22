package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Category;
import com.example.a09cinema_backenddevelop.model.entity.CategoryFilm;
import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.service.*;
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
    private CategoryFilmService categoryFilmService;

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

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/getAllCategoryFilm")
    public ResponseEntity<List<CategoryFilm>> findAllCategoryFilm() {
        List<CategoryFilm> categoryFilms = categoryFilmService.findAllCategoryFilm();
        if (categoryFilms.isEmpty()) {
            return new ResponseEntity<List<CategoryFilm>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryFilm>>(categoryFilms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable("id") Long id) {
        Film film = filmService.findById(id);
        if (film == null) {
            return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Film>(film, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping("/createCategoryFilm/{id}/{categoryId}/{filmId}")
    public ResponseEntity saveCategoryFilm(@PathVariable Long id,
                                           @PathVariable Long categoryId,
                                           @PathVariable Long filmId) {
     return new ResponseEntity<>(categoryFilmService.saveCategoryFilm(id, categoryId, filmId), HttpStatus.CREATED);
    }
    @GetMapping("/findFilmIdByName/{name}")
    public ResponseEntity<Long> findFilmIdByName(@PathVariable("name") String name) {
        Long filmId = filmService.findFilmIdByName(name);
        if (filmId == null) {
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Long>(filmId, HttpStatus.OK);
    }
    @GetMapping("/findNumberOfReCordOfCategoryFilm")
    public ResponseEntity<Long> findNumberOfReCordCategoryFilm() {
        Long numberOfRecord = categoryFilmService.findNumberOfRecord();
        if (numberOfRecord == null) {
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Long>(numberOfRecord,HttpStatus.OK);
    }
}
