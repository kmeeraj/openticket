package com.example.openticket.command;

public class BookingClientInvoker {
    private IBookingCommand bookshow;
    private IBookingCommand unBookshow;

    public BookingClientInvoker(IBookingCommand bookshow, IBookingCommand unBookshow) {
        this.bookshow = bookshow;
        this.unBookshow = unBookshow;
    }

    public void bookShow(){
        this.bookshow.bookShow();
    }

    public void unBookShow() {
        this.unBookshow.unBookShow();
    }

}
