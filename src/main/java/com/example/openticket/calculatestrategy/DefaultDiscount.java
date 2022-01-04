package com.example.openticket.calculatestrategy;

import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Ticket;

import java.util.Locale;

public class DefaultDiscount implements IDiscount{
    private String CITI_CONSTANTS="hyderabad, mumbai, chennai, bangalore, delhi";
    private ScheduleMovie scheduleMovie;
    private Ticket ticket;
    public DefaultDiscount(){

    }
    public DefaultDiscount(ScheduleMovie scheduleMovie, Ticket ticket) {
        this.scheduleMovie = scheduleMovie;
        this.ticket = ticket;
    }

    @Override
    public float getDiscount() {
        String cityName = scheduleMovie.getScreen().getTheater().getCity().getCityName();
        if(CITI_CONSTANTS.contains(cityName.toLowerCase(Locale.ROOT))){
            return 0.5f;
        }
        return 0;
    }

    @Override
    public void setScheduleMovie(ScheduleMovie scheduleMovie) {
        this.scheduleMovie = scheduleMovie;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
