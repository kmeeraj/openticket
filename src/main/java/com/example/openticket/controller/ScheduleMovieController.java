package com.example.openticket.controller;

import com.example.openticket.domain.Movie;
import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Theater;
import com.example.openticket.service.ScheduleMovieService;
import com.example.openticket.service.specifications.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleMovieController {

    @Autowired
    ScheduleMovieService scheduleMovieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return scheduleMovieService.getAllMovies();
    }

    @GetMapping("/schedules")
    public List<ScheduleMovie> getAllScheduleMovies(){
        return scheduleMovieService.getAllScheduleMovies();
    }

    @GetMapping("/theaters")
    public List<Theater> getAllTheaters(){
        return scheduleMovieService.getAllTheaters();
    }

    @GetMapping("/allcityschedule")
    public Page<ScheduleMovie> findTheatersInAllCities(
            @RequestParam("movieName") String movieName,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName));
        return scheduleMovieService.findTheatersInAllCities(movieName, pageable);
    }

    @GetMapping("/cityschedule")
    public Page<ScheduleMovie> findTheatersInCity(
            @RequestParam("movieName") String movieName,
            @RequestParam("cityName") String cityName,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName))
                .and(new MovieInCity(cityName));
        return scheduleMovieService.findTheatersInCity(movieName, cityName, pageable);
    }

    @GetMapping("/cityscheduleOnDate")
    public Page<ScheduleMovie> findTheatersInCityOnDate(
            @RequestParam("movieName") String movieName,
            @RequestParam("cityName") String cityName,
            @RequestParam("movieDate") String movieDate,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName))
                .and(new MovieInCity(cityName))
                .and(new MovieOnDate(movieDate));
        return scheduleMovieService.findTheatersInCityOnDate(movieName, cityName,movieDate, pageable);
    }
    @GetMapping("/cityscheduleOnDateTime")
    public Page<ScheduleMovie> findTheatersInCityOnDateTime(
            @RequestParam("movieName") String movieName,
            @RequestParam("cityName") String cityName,
            @RequestParam("movieDate") String movieDate,
            @RequestParam("movieTimeHour") String movieTimeHour,
            @RequestParam("movieTimeMinute") String movieTimeMinute,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName))
                .and(new MovieInCity(cityName))
                .and(new MovieOnDate(movieDate))
                .and(new MovieOnTimeHour(movieTimeHour))
                .and(new MovieOnTimeMinute(movieTimeMinute));
        return scheduleMovieService.findTheatersInCityOnDateTime(movieName, cityName,movieDate,movieTimeHour, movieTimeMinute,pageable);
    }
}
