package com.example.a09cinema_backenddevelop.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameCategory;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CategoryFilm> categoryFilms;

}

