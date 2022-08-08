package com.example.a09cinema_backenddevelop.repository;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerBookingRepository extends JpaRepository<Booking,Long> {
    @Query(value = "Select * from booking b inner join `account` a on b.account_id=a.id inner join ticket tk on tk.booking_id=b.id inner join film f on f.id=tk.film_id  inner join  seat_detail sd on sd.ticket_id =tk.id inner join `time` t on t.seatdetail_id=sd.id where (b.id like concat('%',:key,'%') or a.id like concat('%',:key ,'%') or a.fullname like concat('%',:key ,'%') or a.id_card like concat('%',:key ,'%') or a.phone like concat('%',:key ,'%') or  f.name like concat('%',:key ,'%') or t.time_show like concat('%',:key ,'%'))and b.received=0 ",
            nativeQuery = true,
            countQuery = "select count(*) from (Select * from booking b inner join `account` a on b.account_id=a.id inner join ticket tk on tk.booking_id=b.id inner join film f on f.id=tk.film_id  inner join  seat_detail sd on sd.ticket_id =tk.id inner join `time` t on t.seatdetail_id=sd.id where (b.id like concat('%',:key,'%') or a.id like concat('%',:key ,'%') or a.fullname like concat('%',:key ,'%') or a.id_card like concat('%',:key ,'%') or a.phone like concat('%',:key ,'%') or  f.name like concat('%',:key ,'%') or t.time_show like concat('%',:key ,'%'))and b.received=0 ) abc " )
    Page<Booking> findAll(@Param("key") String key, Pageable pageable);
    Booking findBookingById(Long id);
//    @Query(value = "update booking set booking.received = 1 where booking.id =:id", nativeQuery = true)
//    Void takeTicket(@Param("id") Long id);



}
