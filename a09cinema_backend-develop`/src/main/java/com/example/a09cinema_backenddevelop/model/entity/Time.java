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

    public Time() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SeatDetail getSeatDetail() {
        return seatDetail;
    }

    public void setSeatDetail(SeatDetail seatDetail) {
        this.seatDetail = seatDetail;
    }

    public String getTimeShow() {
        return timeShow;
    }

    public void setTimeShow(String timeShow) {
        this.timeShow = timeShow;
    }

}
