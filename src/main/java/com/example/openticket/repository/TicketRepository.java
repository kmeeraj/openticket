package com.example.openticket.repository;

import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {
    public List<Ticket> findByScheduleMovie(ScheduleMovie scheduleMovie);
}
