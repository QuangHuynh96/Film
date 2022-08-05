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

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SeatDetail getSeatDetail() {
        return seatDetail;
    }

    public void setSeatDetail(SeatDetail seatDetail) {
        this.seatDetail = seatDetail;
    }
}
