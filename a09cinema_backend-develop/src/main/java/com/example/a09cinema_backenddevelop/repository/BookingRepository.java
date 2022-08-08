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
            "join account on booking.account_id = account.id " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_reward > 0 and account.id = :accountId", nativeQuery = true)
    int findTotalPointReward(LocalDateTime start, LocalDateTime end, Long accountId);

    /*
        Nguyen Phuoc Dai Toan: find total element of list history point exchange
    */
    @Query(value = "select count(booking.id) from booking " +
            "join account on booking.account_id = account.id " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_exchange > 0 and account.id = :accountId", nativeQuery = true)
    int findTotalPointExchange(LocalDateTime start, LocalDateTime end, Long accountId);

    /*
        Nguyen Phuoc Dai Toan: find list history point reward by pagination
    */
    @Query(value = "select booking.id, film.name, booking.day_time_booking, " +
            "booking.point_reward, booking.point_exchange from booking " +
            "join account on booking.account_id = account.id " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_reward > 0 and account.id = :accountId " +
            "limit :offset, :numberRecord", nativeQuery = true)
    List<History> findHistoriesPointReward(LocalDateTime start, LocalDateTime end, int offset, int numberRecord, Long accountId);

    /*
        Nguyen Phuoc Dai Toan: find list history point exchange by pagination
    */
    @Query(value = "select booking.id, film.name, booking.day_time_booking, " +
            "booking.point_reward, booking.point_exchange from booking " +
            "join account on booking.account_id = account.id " +
            "join ticket on booking.id = ticket.booking_id " +
            "join film on ticket.film_id = film.id " +
            "where (booking.day_time_booking between :start and :end) and booking.point_exchange > 0 and account.id = :accountId " +
            "limit :offset, :numberRecord", nativeQuery = true)
    List<History> findHistoriesPointExchange(LocalDateTime start, LocalDateTime end, int offset, int numberRecord, Long accountId);
}
