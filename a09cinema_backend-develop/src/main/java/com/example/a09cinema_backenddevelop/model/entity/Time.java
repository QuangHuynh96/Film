package com.example.a09cinema_backenddevelop.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "seatdetail_id", referencedColumnName = "id")
    private SeatDetail seatDetail;

    private String timeShow;


}
