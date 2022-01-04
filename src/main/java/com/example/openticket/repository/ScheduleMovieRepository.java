package com.example.openticket.repository;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ScheduleMovieRepository extends JpaRepository<ScheduleMovie, Long>, JpaSpecificationExecutor<ScheduleMovie> {
    List<ScheduleMovie> findAllByMovieMovieName(String movieName, Pageable pagable);
    @Cacheable("scheduleMovies")
    Page<ScheduleMovie>  findAll(Specification<ScheduleMovie> specification, Pageable pageable);
}
