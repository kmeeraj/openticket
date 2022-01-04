package com.example.openticket.interconnectobserver.ticket;

import com.example.openticket.domain.Ticket;

public class IMaxMovieUpdateCenter implements IMovieUpdateCenter{

    private MovieTicketNotifyCenter movieTicketNotifyCenter;

    public IMaxMovieUpdateCenter(MovieTicketNotifyCenter movieTicketNotifyCenter){
        this.movieTicketNotifyCenter = movieTicketNotifyCenter;
    }
    @Override
    public void update() {
        Ticket ticket = movieTicketNotifyCenter.getTicket();
    }
}
