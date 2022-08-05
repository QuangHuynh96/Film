package com.example.a09cinema_backenddevelop.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameCategory;
    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;


}
