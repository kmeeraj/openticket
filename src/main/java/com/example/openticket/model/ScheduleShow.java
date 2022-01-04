package com.example.openticket.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ScheduleShow {
    private Long movieId;
    private Long screenId;
    private Long screenHour;
    private Long screenMinute;
    private Long availableSeats;
    private String movieDate;
    private float ticketCost;
}
