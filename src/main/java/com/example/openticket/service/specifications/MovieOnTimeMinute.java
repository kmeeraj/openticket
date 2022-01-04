package com.example.openticket.service.specifications;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovieOnTimeMinute implements Specification<ScheduleMovie> {
    String movieTimeMinute;

    public MovieOnTimeMinute(String movieTimeMinute) {
        this.movieTimeMinute = movieTimeMinute;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleMovie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(movieTimeMinute == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            return criteriaBuilder.ge(root.get("screenMinute"), Integer.parseInt(this.movieTimeMinute));
        }
    }
}
