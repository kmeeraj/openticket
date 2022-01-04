package com.example.openticket.service.specifications;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MovieInCity implements Specification<ScheduleMovie> {
    private String cityName;

    public MovieInCity(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleMovie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(cityName == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            return criteriaBuilder.equal(root.get("screen").get("theater").get("city").get("cityName"), this.cityName);
        }
    }
}
