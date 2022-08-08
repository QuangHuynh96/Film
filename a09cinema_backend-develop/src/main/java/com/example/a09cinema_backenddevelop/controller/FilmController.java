package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Iterable<Film>> findFilmWithPage(Pageable pageable) {
        Page<Film> films = filmService.findAll(pageable);
        if(films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films.getContent(), HttpStatus.OK);
    }

    @GetMapping("/not-pagination")
    public ResponseEntity<List<Film>> findAll() {
        List<Film> films = filmService.findAll();
        if(films.isEmpty()) {
            return new ResponseEntity<>(films, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> findStudentById(@PathVariable Long id) {
        Optional<Film> filmOptional = filmService.findById(id);
        if(!filmOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmOptional.get(), HttpStatus.OK);
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

    @GetMapping("/search")
    public ResponseEntity<Iterable<Film>> searchByName(String name,Pageable pageable) {
        Page<Film> films = filmService.searchByName(name,pageable);
        if(films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films.getContent(), HttpStatus.OK);
    }
}
