package com.example.openticket.controller;

import com.example.openticket.domain.Movie;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TheaterShowControllerTest {

    Logger logger = LoggerFactory.getLogger(TheaterShowControllerTest.class);

    @LocalServerPort
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void newShow() throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("movieId", 2);
        jsonObject.put("screenId", 3);
        jsonObject.put("screenHour", 12);
        jsonObject.put("screenMinute", 55);
        jsonObject.put("availableSeats", 100);
        jsonObject.put("movieDate", "2022-01-04");
        jsonObject.put("ticketCost", 150.0f);
        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);
        String showId= this.restTemplate.postForObject("http://localhost:" + port + "/newShow",request,
                String.class);
        assertNotNull(showId);
        logger.info(showId.toString());
        this.restTemplate.delete("http://localhost:" + port + "/deleteShow/"+showId);
    }


}