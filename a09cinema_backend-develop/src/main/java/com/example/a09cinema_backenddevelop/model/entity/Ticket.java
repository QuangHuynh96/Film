package com.example.a09cinema_backenddevelop.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<SeatDetail> seatDetails;


    public Ticket() {
    }

    public Ticket(long id, Booking booking, Film film, List<SeatDetail> seatDetails) {
        this.id = id;
        this.booking = booking;
        this.film = film;
        this.seatDetails = seatDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<SeatDetail> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(List<SeatDetail> seatDetails) {
        this.seatDetails = seatDetails;
    }
}
