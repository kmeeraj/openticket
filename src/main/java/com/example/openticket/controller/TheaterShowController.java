package com.example.openticket.controller;

import com.example.openticket.domain.*;
import com.example.openticket.model.ScheduleShow;
import com.example.openticket.repository.*;
import com.example.openticket.service.TheaterService;
import com.example.openticket.service.specifications.TheaterShows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class TheaterShowController {

    Logger logger = LoggerFactory.getLogger(TheaterShowController.class);

    @Autowired
    TheaterService theaterService;


    @GetMapping("/theater/{theaterId}")
    Page<ScheduleMovie> allShowsTheater(@PathVariable Long theaterId, Pageable pageable) {
        return theaterService.allShowsTheater(theaterId, pageable);
    }

    @PostMapping("/newShow")
    Long newShow(@RequestBody ScheduleShow scheduleShow) throws ParseException {
        logger.info(scheduleShow.toString());
        return theaterService.newShow(scheduleShow);
    }

    @DeleteMapping("/deleteShow/{showId}")
    Long deleteTicket(@PathVariable Long showId) {
        return theaterService.deleteTicket(showId);
    }
}
