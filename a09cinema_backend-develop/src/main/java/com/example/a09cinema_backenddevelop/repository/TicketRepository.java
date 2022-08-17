package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.BookedTicket;
import com.example.a09cinema_backenddevelop.model.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select new com.example.a09cinema_backenddevelop.model.BookedTicket(t.id, f.name, b.dayTimeBooking,b.totalPrice, b.received) from Ticket t  " +
            "join t.booking b  join t.film f where t.isDeleted <> true ")
    Page<BookedTicket> getBookedTicket(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ticket SET is_deleted = true where id=:id", nativeQuery = true)
    void deleteTicket(Long id);
}

