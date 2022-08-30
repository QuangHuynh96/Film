package com.example.a09cinema_backenddevelop.controller;
import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.a09cinema_backenddevelop.model.entity.Category;
import com.example.a09cinema_backenddevelop.model.entity.CategoryFilm;
import com.example.a09cinema_backenddevelop.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")
@CrossOrigin(origins = "*")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private CategoryFilmService categoryFilmService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<Page<Film>> findFilmWithPage(Pageable pageable) {
        Page<Film> films = filmService.findAll(pageable);
        if(films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteStudent(@PathVariable Long id) {
        Optional<Film> filmOptional = filmService.findById(id);
        if (!filmOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        filmService.deleteById(id);
        return new ResponseEntity<>(filmOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/list/search")
    public ResponseEntity<Page<Film>> search(String value,Pageable pageable) {
        Page<Film> films = filmService.search(value, pageable);
        if(films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Film> saveFilm(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.save(film), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Optional<Film> film1 = filmService.findById(id);
        if (!film1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        film.setId(id);
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
        Optional<Film> film = filmService.findById(id);
        if (!film.isPresent()) {
            return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Film>(film.get(), HttpStatus.OK);
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
