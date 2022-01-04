package com.example.openticket.interconnectobserver.availability;

import com.example.openticket.domain.Ticket;

import java.util.concurrent.CopyOnWriteArraySet;

public class MovieSeatsAvailabilityNotifyCenter implements IMovieSeatAvailabilityNotifyObservable {

    CopyOnWriteArraySet<IMovieSeatsAvailabilityUpdateCenter> movieUpdateCenters = new CopyOnWriteArraySet<IMovieSeatsAvailabilityUpdateCenter>();

    @Override
    public void add(IMovieSeatsAvailabilityUpdateCenter movieUpdateCenter) {
        movieUpdateCenters.add(movieUpdateCenter);
    }

    @Override
    public void remove(IMovieSeatsAvailabilityUpdateCenter movieUpdateCenter) {
        movieUpdateCenters.remove(movieUpdateCenter);
    }

    @Override
    public void notifyMovieTicket() {
        for(IMovieSeatsAvailabilityUpdateCenter movieUpdateCenter : movieUpdateCenters) {
            movieUpdateCenter.update();
        }
    }

    public Ticket getTicket(){
        return null;
    }
}
