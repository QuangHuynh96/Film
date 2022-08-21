package com.example.a09cinema_backenddevelop.controller;

import com.example.a09cinema_backenddevelop.model.dto.SeatDetailDto;
import com.example.a09cinema_backenddevelop.model.dto.TimeDto;
import com.example.a09cinema_backenddevelop.model.entity.Film;
import com.example.a09cinema_backenddevelop.model.entity.SeatDetail;
import com.example.a09cinema_backenddevelop.model.entity.Time;
import com.example.a09cinema_backenddevelop.service.FilmService;
import com.example.a09cinema_backenddevelop.service.SeatDetailService;
import com.example.a09cinema_backenddevelop.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/film/")
@CrossOrigin("*")
public class FilmController {
    private LocalDate today = LocalDate.now();

    @Qualifier("filmServiceImpl")
    @Autowired
    private FilmService filmService;

    @Autowired
    private TimeService timeService;

    @Autowired
    private SeatDetailService seatDetailService;

    @GetMapping(value = "getAllFilm")
    public ResponseEntity<List<Film>> getAllGenre() {
        return ResponseEntity.ok(filmService.findAllListFilm());
    }

    @GetMapping(value = "dateShowOfFilm/{id}")
    public ResponseEntity<List<SeatDetail>> getDateShowOfFilmById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(seatDetailService.getAllSeatDetailByIdFilm(id));
    }

    @GetMapping(value = "timeShowOfFilm/")
    public ResponseEntity<List<TimeDto>> getTimeShowOfFilmById(@RequestParam(value = "date_show") String date_show, @RequestParam(value = "film_id") String film_id) {
        System.out.println(date_show);
        System.out.println(film_id);
        List<TimeDto> timeDtos= timeService.findAllTimeShowBySeatDetail(date_show,film_id);
        System.out.println(timeDtos);
        return ResponseEntity.ok(timeService.findAllTimeShowBySeatDetail(date_show,film_id));
    }

    @GetMapping(value = "findFilmById/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(filmService.findFilmByID(id));
    }

    ///{name}/{dateShow}/{time_id}
//    @GetMapping(value = "findAllSeatDetailByCondition")
//    public ResponseEntity<SeatDetailDto> getFilmById(@RequestBody SeatDetailDto seatDetailDto) {
//        return ResponseEntity.ok(seatDetailService.getIdSeatDetailByBookingCondition(seatDetailDto.getName(),
//                seatDetailDto.getDate_show(), seatDetailDto.getTime_show_id()));
//    }

    @GetMapping(value = "findAllSeatDetailByCondition/")
    public ResponseEntity<SeatDetailDto> getFilmById(@RequestParam(value = "name") String name,
                                                     @RequestParam(value = "date_show") String date_show,
                                                     @RequestParam(value = "time_id") long time_id) {
//        System.out.println(name);
//        System.out.println(date_show);
//        System.out.println(time_id);
        return ResponseEntity.ok(seatDetailService.getIdSeatDetailByBookingCondition(name,
                date_show, time_id));
    }

//    //    TuHC - danh sach phim dang chieu
//    @GetMapping(value = "/movie-showing")
//    public ResponseEntity<List<Movie>> getMovieShowings() {
//        List<Movie> movieShowings = movieService.findAllMovieShowing(today);
//        if (movieShowings.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(movieShowings, HttpStatus.OK);
//        }
//    }
//
//    //    TuHC - phim sap chieu
//    @GetMapping(value = "/movie-coming")
//    public ResponseEntity<List<Movie>> getMovieComingSoon() {
//        List<Movie> movieComingSoons = movieService.findAllMovieComingSoon(today);
//        if (movieComingSoons.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(movieComingSoons, HttpStatus.OK);
//        }
//    }
//
//    //    TuHC - phim top 5
//    @GetMapping(value = "/movie-top5")
//    public ResponseEntity<List<Movie>> getMovieTopFive() {
//        List<Movie> movieTopFives = movieService.listTopFiveMovie();
//        if (movieTopFives.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(movieTopFives, HttpStatus.OK);
//        }
//    }
//
//    //    TuHC - chi tiet phim
//    @GetMapping(value = "/detail-movie/{id}")
//    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id) {
//        Movie movie = movieService.findMovieById(id);
//        if (movie != null) {
//            return new ResponseEntity<>(movie, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }
//
//    //    TuHC - tim kiem phim
//    @GetMapping(value = "/search-movie")
//    public ResponseEntity<List<Movie>> searchMovie(@RequestParam("keyword") String keyword) {
//        List<Movie> movies = movieService.searchMovie(keyword, today);
//        if (movies.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(movies, HttpStatus.OK);
//        }
//    }
//
//    //    TuHC - lay phim dang chieu va sap chieu
//    @GetMapping(value = "/all-movie")
//    public ResponseEntity<List<Movie>> findAllMovieShowingAndComingSoon() {
//        List<Movie> movies = movieService.findAllMovieShowingAndComingSoon();
//        if (movies.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(movies, HttpStatus.OK);
//        }
//    }
}
