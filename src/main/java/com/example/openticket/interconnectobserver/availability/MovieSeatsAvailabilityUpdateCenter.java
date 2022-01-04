package com.example.openticket.interconnectobserver.availability;

import com.example.openticket.domain.Ticket;

public class MovieSeatsAvailabilityUpdateCenter implements IMovieSeatsAvailabilityUpdateCenter {

    private MovieSeatsAvailabilityNotifyCenter movieTicketNotifyCenter;

    public MovieSeatsAvailabilityUpdateCenter(MovieSeatsAvailabilityNotifyCenter movieTicketNotifyCenter){
        this.movieTicketNotifyCenter = movieTicketNotifyCenter;
    }
    @Override
    public void update() {
        Ticket ticket = movieTicketNotifyCenter.getTicket();
    }
}
