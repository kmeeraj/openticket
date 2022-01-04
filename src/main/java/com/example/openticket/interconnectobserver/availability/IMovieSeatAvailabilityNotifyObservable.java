package com.example.openticket.interconnectobserver.availability;

public interface IMovieSeatAvailabilityNotifyObservable {
    public void add(IMovieSeatsAvailabilityUpdateCenter movieUpdateCenter);
    public void remove(IMovieSeatsAvailabilityUpdateCenter movieUpdateCenter);
    public void notifyMovieTicket();
}
