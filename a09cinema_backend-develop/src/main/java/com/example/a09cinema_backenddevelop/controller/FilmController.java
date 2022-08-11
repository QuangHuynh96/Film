package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/api/film")
@Controller
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/findAllFilm")
    public ResponseEntity<List<Film>> findAllFilm() {
        List<Film> films = filmRepository.findAll();
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
//    @GetMapping("/findAllTableWithSearch")
//    public ResponseEntity<List<Film>> findAllTableWithSearch(@RequestParam(value = "name", required = false) String name) {
//        List<Film> films;
//        if (name != null) {
//            films = filmRepository.findAllByNameContaining(name, pageable);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(films, HttpStatus.OK);
//    }
    @GetMapping()
    public ResponseEntity<Film> findAllTableWithSearch(@PageableDefault(size = 10) Pageable pageable, @RequestParam("name") Optional<String> name) {
        Page<Film> filmPage;
        if (name.isPresent()) {
            filmPage = filmRepository.findAllByNameContaining(name.get(), pageable);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Film>((Film) filmPage, HttpStatus.OK);
    }
}
