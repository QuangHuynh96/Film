package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Modifying
    @Query(value = "UPDATE Film SET is_deleted_flag = true where id = :id ", nativeQuery = true)
    void deleteById(Long id);

    @Query(value = "SELECT * FROM Film where is_deleted_flag = false", nativeQuery = true)
    Page<Film> findAll(Pageable pageable);


    @Query(value = "SELECT * FROM Film where (name like concat('%',:name,'%')  or actor like concat('%',:actor,'%')) and is_deleted_flag = false ",
            nativeQuery = true)
    Page<Film> search(@Param("name") String name, @Param("actor") String actor, Pageable pageable);

}
