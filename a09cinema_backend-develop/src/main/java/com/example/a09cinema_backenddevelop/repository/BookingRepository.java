package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.History;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    /*
        Nguyen Phuoc Dai Toan: find total element of list history point reward
    */
    @Query(value = "select count(booking.id) from booking " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_reward > 0 ", nativeQuery = true)
    int findTotalPointReward(LocalDateTime start, LocalDateTime end);

    /*
        Nguyen Phuoc Dai Toan: find total element of list history point exchange
    */
    @Query(value = "select count(booking.id) from booking " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_exchange > 0 ", nativeQuery = true)
    int findTotalPointExchange(LocalDateTime start, LocalDateTime end);

    /*
        Nguyen Phuoc Dai Toan: find list history point reward by pagination
    */
    @Query(value = "select booking.id, film.name, booking.day_time_booking, " +
            "booking.point_reward, booking.point_exchange from booking " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_reward > 0 " +
            "limit :offset, :numberRecord", nativeQuery = true)
    List<History> findHistoriesPointReward(LocalDateTime start, LocalDateTime end, int offset, int numberRecord);

    /*
        Nguyen Phuoc Dai Toan: find list history point exchange by pagination
    */
    @Query(value = "select booking.id, film.name, booking.day_time_booking, " +
            "booking.point_reward, booking.point_exchange from booking " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_exchange > 0 " +
            "limit :offset, :numberRecord", nativeQuery = true)
    List<History> findHistoriesPointExchange(LocalDateTime start, LocalDateTime end, int offset, int numberRecord);

}
