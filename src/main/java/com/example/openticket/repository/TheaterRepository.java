package com.example.openticket.repository;

import com.example.openticket.domain.ScheduleMovie;
import com.example.openticket.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TheaterRepository extends JpaRepository<Theater, Long>, JpaSpecificationExecutor<Theater> {
}
