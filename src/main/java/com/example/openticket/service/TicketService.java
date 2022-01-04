package com.example.openticket.service;

import com.example.openticket.calculatestrategy.CalculateAmount;
import com.example.openticket.calculatestrategy.DefaultCoupons;
import com.example.openticket.calculatestrategy.DefaultDiscount;
import com.example.openticket.calculatestrategy.DefaultTax;
import com.example.openticket.service.specifications.TicketsOfSchedule;
import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Ticket;
import com.example.openticket.repository.ScheduleMovieRepository;
import com.example.openticket.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    Logger logger = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    ScheduleMovieRepository scheduleMovieRepository;

    @Autowired
    TicketRepository ticketRepository;

    public Ticket newTicket(Long scheduleId, Long numberOfTicket) {
        ScheduleMovie scheduleMovie = scheduleMovieRepository.getById(scheduleId);
        if(scheduleMovie.getAvailableSeats() >= numberOfTicket){
            scheduleMovie.setAvailableSeats(scheduleMovie.getAvailableSeats() - numberOfTicket.intValue());
            scheduleMovie = scheduleMovieRepository.save(scheduleMovie);
            Ticket ticket = new Ticket(numberOfTicket.intValue(),scheduleMovie);
            CalculateAmount calculateAmount = new CalculateAmount(scheduleMovie,ticket, new DefaultCoupons(), new DefaultDiscount(scheduleMovie, ticket), new DefaultTax());
            ticket.setTicketCost(calculateAmount.getTicketPrice());
            ticketRepository.save(ticket);
            logger.info(ticket.toString());
            return ticket;
        }
        return null;
    }

    public Long deleteTicket(Long ticketId) {
        Ticket ticket = ticketRepository.getById(ticketId);
        ScheduleMovie scheduleMovie = ticket.getScheduleMovie();
        scheduleMovie.setAvailableSeats(scheduleMovie.getAvailableSeats() + ticket.getNumberOfSeats());
        scheduleMovieRepository.save(scheduleMovie);
        ticketRepository.delete(ticket);
        return ticketId;
    }
    public Page<Ticket> allTicketsOfSchedule(Long scheduleId, Pageable pageable) {
        Specification<Ticket> spec = Specification.where(new TicketsOfSchedule(scheduleId.toString()));
        return ticketRepository.findAll(spec, pageable);
    }
}
