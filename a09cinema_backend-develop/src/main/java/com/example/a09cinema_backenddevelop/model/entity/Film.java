package com.example.a09cinema_backenddevelop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Date startDate;
    private Date endDate;
    private String actor;
    private String director;
    private String duration;
    private String trailer;
    private String studioName;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<FilmImg> filmImgs;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
