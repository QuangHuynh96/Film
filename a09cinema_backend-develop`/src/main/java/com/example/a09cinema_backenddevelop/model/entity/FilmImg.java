package com.example.a09cinema_backenddevelop.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class FilmImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

    public FilmImg() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
