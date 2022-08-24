package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@JsonIdentityInfo(generator= JSOGGenerator.class)
public class FilmImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

}
