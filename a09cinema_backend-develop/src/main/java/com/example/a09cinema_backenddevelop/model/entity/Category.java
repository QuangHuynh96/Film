package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameCategory;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryFilm> categoryFilms;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category() {
    }

    public Category(long id, String nameCategory, Film film) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public List<CategoryFilm> getCategoryFilms() {
        return categoryFilms;
    }

    public void setCategoryFilms(List<CategoryFilm> categoryFilms) {
        this.categoryFilms = categoryFilms;
    }
}
