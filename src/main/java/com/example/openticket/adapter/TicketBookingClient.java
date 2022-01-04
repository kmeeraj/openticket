package com.example.openticket.adapter;

public class TicketBookingClient {

    public void bookTicket(){
        ITicketBookingTarget ticketBookingTarget = new TicketBookingAdapter(new TicketBookingAdaptee());
        ticketBookingTarget.bookTicketRequest();
    }
}
