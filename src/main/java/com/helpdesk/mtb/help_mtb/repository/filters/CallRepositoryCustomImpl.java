package com.helpdesk.mtb.help_mtb.repository.filters;

import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.model.Call;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CallRepositoryCustomImpl implements CallRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Call> findCallsByFilter(CallFilter filter) {
        var cb = entityManager.getCriteriaBuilder();
        var query = cb.createQuery(Call.class);
        var root = query.from(Call.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getCompanyId() != null) {
            predicates.add(cb.equal(root.get("companyId"), filter.getCompanyId()));
        }

        if (filter.getClientId() != null) {
            predicates.add(cb.equal(root.get("clientId"), filter.getClientId()));
        }

        if (filter.getConnection() != null && !filter.getConnection().isEmpty()) {
            predicates.add(cb.like(root.get("connection"), "%" + filter.getConnection() + "%"));
        }

        if (filter.getTitle() != null && !filter.getTitle().isEmpty()) {
            predicates.add(cb.like(root.get("title"), "%" + filter.getTitle() + "%"));
        }

        if (filter.getDescription() != null && !filter.getDescription().isEmpty()) {
            predicates.add(cb.like(root.get("description"), "%" + filter.getDescription() + "%"));
        }

        if (filter.getResolution() != null && !filter.getResolution().isEmpty()) {
            predicates.add(cb.like(root.get("resolution"), "%" + filter.getResolution() + "%"));
        }

        if (filter.getTags() != null && !filter.getTags().isEmpty()) {
            predicates.add(cb.like(root.get("tags"), "%" + filter.getTags() + "%"));
        }

        if (filter.getClosed() != null) {
            predicates.add(cb.equal(root.get("closed"), filter.getClosed()));
        }

        if (filter.getCreated() != null) {
            // Considerando apenas a data, ignorando o tempo
            predicates.add(cb.greaterThanOrEqualTo(root.get("created"), filter.getCreated().toLocalDate().atStartOfDay()));
            predicates.add(cb.lessThan(root.get("created"), filter.getCreated().toLocalDate().plusDays(1).atStartOfDay()));
        }

        if (filter.getFinalized() != null) {
            // Considerando apenas a data, ignorando o tempo
            predicates.add(cb.greaterThanOrEqualTo(root.get("finalized"), filter.getFinalized().toLocalDate().atStartOfDay()));
            predicates.add(cb.lessThan(root.get("finalized"), filter.getFinalized().toLocalDate().plusDays(1).atStartOfDay()));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
