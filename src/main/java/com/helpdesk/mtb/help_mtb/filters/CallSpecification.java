package com.helpdesk.mtb.help_mtb.filters;

import com.helpdesk.mtb.help_mtb.model.Call;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class CallSpecification implements Specification<Call> {
    private final CallFilter filter;

    public CallSpecification(CallFilter filter) {
        this.filter = filter;
    }


    @Override
    public Predicate toPredicate(Root<Call> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (filter.getCompanyId() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("companyId"), filter.getCompanyId()));
        }
        if (filter.getClientId() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("clientId"), filter.getClientId()));
        }
        if (filter.getTitle() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + filter.getTitle().toLowerCase() + "%"));
        }
        if (filter.getDescription() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + filter.getDescription().toLowerCase() + "%"));
        }
        if (filter.getResolution() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("resolution")), "%" + filter.getResolution().toLowerCase() + "%"));
        }
        if (filter.getTags() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("tags")), "%" + filter.getTags().toLowerCase() + "%"));
        }
        if (filter.getClosed() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("closed"), filter.getClosed()));
        }
        if (filter.getCreated() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("created"), filter.getCreated()));
        }
        if (filter.getFinalized() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("finalized"), filter.getFinalized()));
        }

        return predicate;
    }
}
