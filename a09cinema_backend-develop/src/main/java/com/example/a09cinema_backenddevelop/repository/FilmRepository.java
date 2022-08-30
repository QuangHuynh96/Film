package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

    @Query(value = "SELECT * FROM Film where is_deleted_flag = false ", nativeQuery = true)
    Page<Film> findAll(Pageable pageable);


    @Query(value = "SELECT * FROM Film where (name like concat('%',:name,'%')  or actor like concat('%',:actor,'%')) and is_deleted_flag = false ",
            nativeQuery = true)
    Page<Film> search(@Param("name") String name, @Param("actor") String actor, Pageable pageable);

    @Query(value = "SELECT film.* FROM film inner join seat_detail on film.id = seat_detail.film_id where seat_detail.date_show between date(now()) and date(now())+ interval 4 day  ", nativeQuery = true)
    Page<Film> findSort(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM a0921i1_cinema.film \n" +
            "inner join seat_detail on film.id=seat_detail.film_id \n" +
            "inner join `time` on seat_detail.time_id=`time`.id\n" +
            "where (seat_detail.date_show between date(now()) and date(now())+ interval 4 day) \n" +
            "group by film.name;")
    List<Film> getAllFilm();

    @Query(nativeQuery = true, value = "SELECT * FROM a0921i1_cinema.film where film.id=?1")
    Film findFilmById(Long id);
}
