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
    @Query(value = "SELECT * FROM Film where is_deleted_flag = false order by film.start_day desc ", nativeQuery = true)
    Page<Film> findSort(Pageable pageable);
}
