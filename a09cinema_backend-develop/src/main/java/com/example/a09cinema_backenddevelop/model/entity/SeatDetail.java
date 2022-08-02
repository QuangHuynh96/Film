package com.example.a09cinema_backenddevelop.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity

public class SeatDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean isFlag;
    private Date dateShow;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    @OneToMany(mappedBy = "seatDetail", cascade = CascadeType.ALL)
    private List<Time> times;

    @OneToMany(mappedBy = "seatDetail", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "seatDetail", cascade = CascadeType.ALL)
    private List<Seat> seats;
}
