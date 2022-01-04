package com.example.openticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class ScheduleMovie {
    private
    @TableGenerator(name = "Schedule_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Schedule_Gen", initialValue = 100, allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Schedule_Gen")
    Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Movie movie;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "screen_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Screen screen;
    private Date screenDate;
    private int screenHour;
    private int screenMinute;
    private int availableSeats;
    private float ticketCost;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "scheduleMovie")
    @JsonIgnore
    private Set<Ticket> tickets = new HashSet<>();

    public ScheduleMovie(Movie movie, Screen screen, Date screenDate, int screenHour, int screenMinute, int availableSeats, float ticketCost) {
        this.movie = movie;
        this.screen = screen;
        this.screenDate = screenDate;
        this.screenHour = screenHour;
        this.screenMinute = screenMinute;
        this.availableSeats = availableSeats;
        this.ticketCost = ticketCost;
    }

    public ScheduleMovie() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleMovie)) return false;
        ScheduleMovie that = (ScheduleMovie) o;
        return getScreenHour() == that.getScreenHour() && getScreenMinute() == that.getScreenMinute() && getAvailableSeats() == that.getAvailableSeats() && getMovie().equals(that.getMovie()) && getScreen().equals(that.getScreen()) && getScreenDate().equals(that.getScreenDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie(), getScreen(), getScreenDate(), getScreenHour(), getScreenMinute(), getAvailableSeats());
    }

    @Override
    public String toString() {
        return "ScheduleMovie{" +
                "id=" + id +
                "movie=" + movie +
                ", screen=" + screen +
                ", screenDate=" + screenDate +
                ", screenHour=" + screenHour +
                ", screenMinute=" + screenMinute +
                '}';
    }
}
