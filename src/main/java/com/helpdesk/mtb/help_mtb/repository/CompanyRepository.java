package com.helpdesk.mtb.help_mtb.repository;

import com.helpdesk.mtb.help_mtb.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
