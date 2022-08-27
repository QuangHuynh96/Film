package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
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

    @JsonManagedReference("film_imgs")
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//    @JsonIgnore
//    @JsonBackReference
    private List<FilmImg> filmImgs;
    @JsonManagedReference("seat_detail")
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<SeatDetail> seatDetails;
    @JsonManagedReference("category_films")
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<CategoryFilm> categoryFilms;


}
