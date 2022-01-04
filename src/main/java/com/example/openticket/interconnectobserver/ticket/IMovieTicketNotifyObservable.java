package com.example.openticket.interconnectobserver.ticket;

public interface IMovieTicketNotifyObservable {
    public void add(IMovieUpdateCenter movieUpdateCenter);
    public void remove(IMovieUpdateCenter movieUpdateCenter);
    public void notifyMovieTicket();
}
