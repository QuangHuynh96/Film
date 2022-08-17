package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int size;
    private boolean status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<SeatDetail> seatDetail;
}

