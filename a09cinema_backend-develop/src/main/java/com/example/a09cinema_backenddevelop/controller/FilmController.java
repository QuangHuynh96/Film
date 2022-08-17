package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/info")
    public Film getInfoFilm(@RequestParam("id") long id){
        Film filmInfo = this.filmService.findFilmById(id);
        return filmInfo;
    }

    @GetMapping("/list")
    public List<Film> getAll(){
        return this.filmService.findAll();
    }



}
