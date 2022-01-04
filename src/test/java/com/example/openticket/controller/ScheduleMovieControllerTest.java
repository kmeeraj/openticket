package com.example.openticket.controller;

import com.example.openticket.domain.Movie;
import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Theater;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScheduleMovieControllerTest {

    @LocalServerPort
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllMovies() {
        List<Movie> movies= this.restTemplate.getForObject("http://localhost:" + port + "/movies",
                List.class);
        assertEquals(movies.size(), 7);
    }

    @Test
    void getAllScheduleMovies() {
        List<ScheduleMovie> scheduleMovies= this.restTemplate.getForObject("http://localhost:" + port + "/schedules",
                List.class);
        assertEquals(scheduleMovies.size(), 73);
    }

    @Test
    void getAllTheaters() {
        List<Theater> theaters= this.restTemplate.getForObject("http://localhost:" + port + "/theaters",
                List.class);
        assertEquals(theaters.size(), 12);
    }

}