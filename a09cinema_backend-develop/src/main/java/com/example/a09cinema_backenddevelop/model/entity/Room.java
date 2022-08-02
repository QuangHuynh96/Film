package com.example.a09cinema_backenddevelop.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int size;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "seatdetail_id", referencedColumnName = "id")
    private SeatDetail seatDetail;
}
