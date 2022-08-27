package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean vip;
    private String name;
    private double price;
    @JsonManagedReference
    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<SeatDetail> seatDetail;

    public Seat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<SeatDetail> getSeatDetail() {
        return seatDetail;
    }

    public void setSeatDetail(List<SeatDetail> seatDetail) {
        this.seatDetail = seatDetail;
    }
}
