package com.example.openticket.service;

import com.example.openticket.domain.Movie;
import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Theater;
import com.example.openticket.repository.*;
import com.example.openticket.service.specifications.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ScheduleMovieService {
    Logger logger = LoggerFactory.getLogger(ScheduleMovieService.class);

    @Autowired
    CityRepository cityRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    ScheduleMovieRepository scheduleMovieRepository;

    @Autowired
    TheaterRepository theaterRepository;


    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }


    public List<ScheduleMovie> getAllScheduleMovies(){
        return scheduleMovieRepository.findAll();
    }


    public List<Theater> getAllTheaters(){
        return theaterRepository.findAll();
    }


    public Page<ScheduleMovie> findTheatersInAllCities(
            String movieName,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName));
        return scheduleMovieRepository.findAll(spec, pageable);
    }


    public Page<ScheduleMovie> findTheatersInCity(
            String movieName,
            String cityName,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName))
                .and(new MovieInCity(cityName));
        return scheduleMovieRepository.findAll(spec, pageable);
    }


    public Page<ScheduleMovie> findTheatersInCityOnDate(
            String movieName,
            String cityName,
             String movieDate,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName))
                .and(new MovieInCity(cityName))
                .and(new MovieOnDate(movieDate));
        return scheduleMovieRepository.findAll(spec, pageable);
    }
    
    public Page<ScheduleMovie> findTheatersInCityOnDateTime(
            String movieName,
         String cityName,
            String movieDate,
            String movieTimeHour,
             String movieTimeMinute,
            Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new MovieWithName(movieName))
                .and(new MovieInCity(cityName))
                .and(new MovieOnDate(movieDate))
                .and(new MovieOnTimeHour(movieTimeHour))
                .and(new MovieOnTimeMinute(movieTimeMinute));
        return scheduleMovieRepository.findAll(spec, pageable);
    }
}
