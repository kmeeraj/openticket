package com.example.openticket.calculatestrategy;

import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Ticket;

public interface IDiscount {
    public float getDiscount();
    public void setScheduleMovie(ScheduleMovie scheduleMovie);
    public void setTicket(Ticket ticket);
}
