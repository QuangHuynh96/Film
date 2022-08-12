package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.BookedTicket;
import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select new com.example.a09cinema_backenddevelop.model.BookedTicket(f.name, b.dayTimeBooking,b.totalPrice, b.received) from Ticket t  " +
            "join t.booking b  join t.film f ")
    Page<BookedTicket> getBookedTicket(Pageable pageable);
//    @Query(value = "select film.name as name, booking.day_time_booking as day_time_booking, booking.received as received,booking.total_price as total_price from ticket  " +
//            "join booking on  booking.id=ticket.booking_id join film on film.id=ticket.film_id where ticket.film_id=film.id and ticket.booking_id=booking.id", nativeQuery = true)
//    Page<BookedTicket> getBookedTicket(Pageable pageable);
//    @Query(value = "select new com.example.a09cinema_backenddevelop.model.BookedTicket(f.name, b.day_time_booking, b.received,b.total_price) from film as f " +
//            "join booking as b join ticket as t where t.film_id=f.id and t.booking_id=b.id",nativeQuery = true)
//    Page<BookedTicket> getBookedTicket(Pageable pageable);
//where t.film_id=f.id and t.booking_id=b.id")
}
