package com.example.openticket.calculatestrategy;

import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Ticket;

public class CalculateAmount {

    private ScheduleMovie scheduleMovie;
    private Ticket ticket;
    private ICoupons coupons;
    private IDiscount discount;
    private ITax tax;

    public CalculateAmount(ScheduleMovie scheduleMovie, Ticket ticket, ICoupons coupons, IDiscount discount, ITax tax){
        this.scheduleMovie =scheduleMovie;
        this.ticket = ticket;
        this.coupons = coupons;
        this.discount = discount;
        this.tax = tax;
    }

    public Float getTicketPrice() {
        float price = this.scheduleMovie.getTicketCost();
        int numberOfTicket = this.ticket.getNumberOfSeats();
        float cost = price * numberOfTicket;
        return cost - this.coupons.applyCoupons() - this.discount.getDiscount()*cost + this.tax.getTax()*cost;
    }

}
