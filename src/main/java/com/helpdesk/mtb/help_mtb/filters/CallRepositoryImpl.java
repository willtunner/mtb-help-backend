package com.helpdesk.mtb.help_mtb.filters;

import com.helpdesk.mtb.help_mtb.model.Call;
import com.helpdesk.mtb.help_mtb.repository.CallRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CallRepositoryImpl implements CallRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Call> findByFilter(CallFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Call> query = cb.createQuery(Call.class);
        Root<Call> call = query.from(Call.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getCompanyId() != null) {
            predicates.add(cb.equal(call.get("companyId"), filter.getCompanyId()));
        }

        if (filter.getClientId() != null) {
            predicates.add(cb.equal(call.get("clientId"), filter.getClientId()));
        }

        if (filter.getTitle() != null && !filter.getTitle().isEmpty()) {
            predicates.add(cb.like(call.get("title"), "%" + filter.getTitle() + "%"));
        }

        if (filter.getDescription() != null && !filter.getDescription().isEmpty()) {
            predicates.add(cb.like(call.get("description"), "%" + filter.getDescription() + "%"));
        }

        if (filter.getResolution() != null && !filter.getResolution().isEmpty()) {
            predicates.add(cb.like(call.get("resolution"), "%" + filter.getResolution() + "%"));
        }

        if (filter.getTags() != null && !filter.getTags().isEmpty()) {
            predicates.add(cb.like(call.get("tags"), "%" + filter.getTags() + "%"));
        }

        if (filter.getClosed() != null) {
            predicates.add(cb.equal(call.get("closed"), filter.getClosed()));
        }

        if (filter.getCreated() != null) {
            predicates.add(cb.greaterThanOrEqualTo(call.get("created"), filter.getCreated()));
        }

        if (filter.getFinalized() != null) {
            predicates.add(cb.lessThanOrEqualTo(call.get("finalized"), filter.getFinalized()));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
