
package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    private List<FilmImg> filmImgs;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<SeatDetail> seatDetails;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//    @JsonBackReference
    private List<CategoryFilm> categoryFilms;

}