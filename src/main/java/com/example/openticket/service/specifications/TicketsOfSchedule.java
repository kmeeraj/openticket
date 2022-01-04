package com.example.openticket.service.specifications;

import com.example.openticket.domain.Ticket;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TicketsOfSchedule implements Specification<Ticket> {
    String scheduleId;

    public TicketsOfSchedule(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(scheduleId == null){
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        } else {
            return criteriaBuilder.equal(root.get("scheduleMovie").get("id"), this.scheduleId);
        }
    }
}
