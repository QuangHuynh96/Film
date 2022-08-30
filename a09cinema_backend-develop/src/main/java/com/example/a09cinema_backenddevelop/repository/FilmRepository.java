package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.a09cinema_backenddevelop.model.entity.CategoryFilm;
import com.example.a09cinema_backenddevelop.model.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    @Query(value = "select * from category_film", nativeQuery = true)
    List<CategoryFilm> findAllCategoryFilm();

//    @Query(value = "SELECT * FROM Blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%')",
//            nativeQuery = true,
//            countQuery = "select count(*) from ( SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ) abc ")
//    Page<Blog> findByAuthorAndCategory(@Param("author") String author, @Param("category") String category, Pageable pageable);

    @Query(value= "INSERT INTO `category_film` (`category_id`,`film_id`) VALUES (:category_id,:film_id)", nativeQuery=true)
    List<CategoryFilm> saveCategoryFilm(@Param("category_id") Long category_id, @Param("film_id") Long film_id);

    Film findFilmById(Long id);

    @Query(value="SELECT id FROM a0921i1_cinema.film where `name` = :name",nativeQuery=true)
    Long findFilmIdByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Film SET is_deleted_flag = true where id = :id ", nativeQuery = true)
    void deleteById(Long id);

    @Query(value = "SELECT * FROM Film where is_deleted_flag = false", nativeQuery = true)
    Page<Film> findAll(Pageable pageable);


    @Query(value = "SELECT * FROM Film where (name like concat('%',:name,'%')  or actor like concat('%',:actor,'%')) and is_deleted_flag = false ",
            nativeQuery = true)
    Page<Film> search(@Param("name") String name, @Param("actor") String actor, Pageable pageable);
}
