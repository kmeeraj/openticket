package com.example.openticket.service.specifications;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovieOnTimeHour implements Specification<ScheduleMovie> {
    String movieTimeHour;

    public MovieOnTimeHour(String movieTimeHour) {
        this.movieTimeHour = movieTimeHour;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleMovie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(movieTimeHour == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            return criteriaBuilder.ge(root.get("screenHour"), Integer.parseInt(this.movieTimeHour));
        }
    }
}
