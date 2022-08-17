package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean vip;
    private String name;
    private double price;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<SeatDetail> seatDetail;


}
