package com.example.openticket.service;

import com.example.openticket.controller.TheaterShowController;
import com.example.openticket.domain.Movie;
import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Screen;
import com.example.openticket.domain.Ticket;
import com.example.openticket.model.ScheduleShow;
import com.example.openticket.repository.*;
import com.example.openticket.service.specifications.TheaterShows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    Logger logger = LoggerFactory.getLogger(TheaterService.class);

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    ScheduleMovieRepository scheduleMovieRepository;

    public Page<ScheduleMovie> allShowsTheater( Long theaterId, Pageable pageable) {
        Specification<ScheduleMovie> spec = Specification.where(new TheaterShows(theaterId.toString()));
        return scheduleMovieRepository.findAll(spec, pageable);
    }

    public Long newShow( ScheduleShow scheduleShow) throws ParseException {
        logger.info(scheduleShow.toString());
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(scheduleShow.getMovieDate());
        Screen screen = screenRepository.getById(scheduleShow.getScreenId());
        Movie movie = movieRepository.getById(scheduleShow.getMovieId());
        ScheduleMovie scheduleMovie = new ScheduleMovie(movie, screen,date, scheduleShow.getScreenHour().intValue(), scheduleShow.getScreenMinute().intValue(), scheduleShow.getAvailableSeats().intValue(),scheduleShow.getTicketCost() );
        scheduleMovie = scheduleMovieRepository.save(scheduleMovie);
        return scheduleMovie.getId();
    }

    public Long deleteTicket(Long showId) {
        Optional<ScheduleMovie> scheduleMovie = scheduleMovieRepository.findById(showId);
        List<Ticket> tickets = ticketRepository.findByScheduleMovie(scheduleMovie.get());
        for(Ticket ticket: tickets) {
            ticketRepository.delete(ticket);
        }
        scheduleMovieRepository.delete(scheduleMovie.get());
        return showId;
    }
}
