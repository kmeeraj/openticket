package com.example.openticket.controller;

import com.example.openticket.domain.Ticket;
import com.example.openticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookMovieShowController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/tickets/{scheduleId}/{numberOfTicket}")
    Ticket newTicket(@PathVariable Long scheduleId, @PathVariable Long numberOfTicket) {
        return ticketService.newTicket(scheduleId, numberOfTicket);
    }

    @DeleteMapping("/deleteTicket/{ticketId}")
    Long deleteTicket(@PathVariable Long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @GetMapping("/alltickets/{scheduleId}")
    Page<Ticket> allTicketsOfSchedule(@PathVariable Long scheduleId, Pageable pageable) {
        return ticketService.allTicketsOfSchedule(scheduleId, pageable);
    }

}
