package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.model.entity.FilmImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmImgRepository extends JpaRepository<FilmImg,Long> {

}
