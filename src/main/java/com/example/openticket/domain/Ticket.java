package com.example.openticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
public class Ticket {
    private @Id
    @GeneratedValue
    Long id;
    private int numberOfSeats;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "schedule_movie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ScheduleMovie scheduleMovie;
    private String seatNumbers;
    private float ticketCost;

    public Ticket(int numberOfSeats, ScheduleMovie scheduleMovie) {
        this.numberOfSeats = numberOfSeats;
        this.scheduleMovie = scheduleMovie;
    }

    public Ticket() {

    }
}
