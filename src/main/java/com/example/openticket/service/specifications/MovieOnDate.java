package com.example.openticket.service.specifications;

import com.example.openticket.domain.ScheduleMovie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MovieOnDate implements Specification<ScheduleMovie> {
    String date;

    public MovieOnDate(String date) {
        this.date = date;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleMovie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(date == null){
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            try {
                return criteriaBuilder.equal(root.get("screenDate"), new SimpleDateFormat("yyyy-MM-dd").parse(this.date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
