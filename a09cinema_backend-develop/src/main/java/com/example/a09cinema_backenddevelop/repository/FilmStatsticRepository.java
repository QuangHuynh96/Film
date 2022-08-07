package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmStatsticRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select film.`name` , count(ticket.film_id) as NumbersTicket , sum(booking.total_price) money " +
            "from film " +
            "inner join ticket " +
            "on film.id = ticket.film_id " +
            "inner join booking " +
            "on ticket.booking_id = booking.id " +
            "where booking.day_time_booking = CURDATE() " +
            "group by film.`name`;", nativeQuery = true)
    List<?> statisticalByCurrentDay();

}
