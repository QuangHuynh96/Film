package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select f.name, b.day_time_booking, b.received,b.total_price from film as f " +
            "join booking as b join ticket as t where t.film_id=f.id and t.booking_id=b.id", nativeQuery = true)
    List getBookedTicket();

}
