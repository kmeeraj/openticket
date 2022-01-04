package com.example.openticket.service.specifications;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TheaterShows implements Specification<ScheduleMovie> {
    String theaterId;

    public TheaterShows(String theaterId) {
        this.theaterId = theaterId;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleMovie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(this.theaterId == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            return criteriaBuilder.equal(root.get("screen").get("theater").get("id"), this.theaterId);
        }
    }
}
