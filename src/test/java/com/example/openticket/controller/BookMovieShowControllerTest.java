package com.example.openticket.controller;

import com.example.openticket.domain.Theater;
import com.example.openticket.domain.Ticket;
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
class BookMovieShowControllerTest {

    Logger logger = LoggerFactory.getLogger(BookMovieShowControllerTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void newTicket() throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);
        Ticket ticket= this.restTemplate.postForObject("http://localhost:" + port + "/tickets/37/11",request,
                Ticket.class);
        logger.info(ticket.toString());
        assertNotNull(ticket);
        String tickets= this.restTemplate.getForObject("http://localhost:" + port + "/alltickets/37",
                String.class);
        logger.info(tickets);
        assertNotNull(ticket);
        this.restTemplate.delete("http://localhost:" + port + "/deleteTicket/"+ticket.getId());
    }


}