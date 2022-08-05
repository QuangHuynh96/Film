package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
//@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean vip;
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "seatdetail_id", referencedColumnName = "id")
    private SeatDetail seatDetail;


}
