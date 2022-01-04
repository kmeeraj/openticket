package com.example.openticket;

import com.example.openticket.controller.BookMovieShowController;
import com.example.openticket.controller.ScheduleMovieController;
import com.example.openticket.controller.TheaterShowController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private BookMovieShowController bookMovieShowController;

    @Autowired
    private ScheduleMovieController scheduleMovieController;

    @Autowired
    private TheaterShowController theaterShowController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(bookMovieShowController).isNotNull();
        assertThat(scheduleMovieController).isNotNull();
        assertThat(theaterShowController).isNotNull();
    }
}
