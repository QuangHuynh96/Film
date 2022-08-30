package com.example.a09cinema_backenddevelop.repository;
import com.example.a09cinema_backenddevelop.model.dto.SeatDetailDto;
import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.a09cinema_backenddevelop.model.dto.SeatDetailDto;
import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatDetailRepository extends JpaRepository<SeatDetail,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM a0921i1_cinema.seat_detail where film_id=?1 group  by date_show order  by date_show")
    List<SeatDetail> getAllSeatDetailByIdFilm(Long id);

    @Query(nativeQuery = true,value = "SELECT seat_detail.id, seat_detail.date_show, `time`.id as time_id, film.name FROM seat_detail \n" +
            "inner join film on seat_detail.film_id=film.id \n" +
            "inner join `time` on `time`.id= seat_detail.time_id \n" +
            "where film.`name` = ?1 and seat_detail.date_show = ?2 and time_id=?3 \n" +
            "group by seat_detail.date_show" +
            "order by seat_detail.date_show")
    SeatDetailDto getIdSeatDetailByBookingCondition(String name, String date_show, long time_id);
}

