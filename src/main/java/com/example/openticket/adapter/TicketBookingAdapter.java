package com.example.openticket.adapter;

public class TicketBookingAdapter implements ITicketBookingTarget{
    private TicketBookingAdaptee ticketBookingAdaptee;
    public TicketBookingAdapter(TicketBookingAdaptee ticketBookingAdaptee){
        this.ticketBookingAdaptee = ticketBookingAdaptee;
    }
    @Override
    public void bookTicketRequest() {
        this.ticketBookingAdaptee.bookTicket();
    }
}
