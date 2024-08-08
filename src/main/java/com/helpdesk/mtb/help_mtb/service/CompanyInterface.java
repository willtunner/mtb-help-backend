package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.Company;

import java.util.List;

public interface CompanyInterface {

    Company createCompany(Company company);
    List<Company> getAllCompany();
    Company addUserToCompany(Long companyId, Long userId);
}
