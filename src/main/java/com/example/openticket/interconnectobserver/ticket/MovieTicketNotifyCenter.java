package com.example.openticket.interconnectobserver.ticket;

import com.example.openticket.domain.Ticket;

import java.util.concurrent.CopyOnWriteArraySet;

public class MovieTicketNotifyCenter implements IMovieTicketNotifyObservable{

    CopyOnWriteArraySet<IMovieUpdateCenter> movieUpdateCenters = new CopyOnWriteArraySet<IMovieUpdateCenter>();

    @Override
    public void add(IMovieUpdateCenter movieUpdateCenter) {
        movieUpdateCenters.add(movieUpdateCenter);
    }

    @Override
    public void remove(IMovieUpdateCenter movieUpdateCenter) {
        movieUpdateCenters.remove(movieUpdateCenter);
    }

    @Override
    public void notifyMovieTicket() {
        for(IMovieUpdateCenter movieUpdateCenter : movieUpdateCenters) {
            movieUpdateCenter.update();
        }
    }

    public Ticket getTicket(){
        return null;
    }
}
