package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.model.Call;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CallSpecification {

    public static Specification<Call> filterBy(CallFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getCompanyId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("companyId"), filter.getCompanyId()));
            }
            if (filter.getClientId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("clientId"), filter.getClientId()));
            }
            if (filter.getTitle() != null && !filter.getTitle().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + filter.getTitle().toLowerCase() + "%"));
            }
            if (filter.getDescription() != null && !filter.getDescription().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + filter.getDescription().toLowerCase() + "%"));
            }
            if (filter.getTags() != null && !filter.getTags().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("tags")), "%" + filter.getTags().toLowerCase() + "%"));
            }
            if (filter.getClosed() != null) {
                predicates.add(criteriaBuilder.equal(root.get("closed"), filter.getClosed()));
            }
            if (filter.getCreated() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("created"), filter.getCreated()));
            }
            if (filter.getFinalized() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("finalized"), filter.getFinalized()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}