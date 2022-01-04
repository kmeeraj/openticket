package com.example.openticket.service.specifications;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovieWithName implements Specification<ScheduleMovie> {
    private String movieName;

    public MovieWithName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleMovie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(movieName == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            return criteriaBuilder.equal(root.get("movie").get("movieName"), this.movieName);
        }
    }
}
