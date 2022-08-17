package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.DTO.StatisticFilm;
import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmStatsticRepository extends JpaRepository<SeatDetail, Long> {

    @Query(value = "select film.name , count(seat_detail.film_id) as numbersTicket , sum(booking.total_price) money " +
            "from film " +
            "inner join seat_detail " +
            "on film.id = seat_detail.film_id " +
            "inner join booking  " +
            "on seat_detail.booking_id = booking.id " +
            "where booking.day_time_booking = CURDATE() " +
            "group by film.name;", nativeQuery = true)
    List<StatisticFilm> statisticalByCurrentDay();

    @Query(value="select count(film.id) amount_film from film; ", nativeQuery= true)
    String countNameFilm();

    @Query(value="select count(booking.id) amount_ticket from booking; ", nativeQuery= true)
    String countTicket();

}
