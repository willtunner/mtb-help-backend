package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.Client;
import com.helpdesk.mtb.help_mtb.model.Company;
import com.helpdesk.mtb.help_mtb.model.User;
import com.helpdesk.mtb.help_mtb.repository.ClientRepository;
import com.helpdesk.mtb.help_mtb.repository.CompanyRepository;
import com.helpdesk.mtb.help_mtb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements CompanyInterface {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company addUserToCompany(Long companyId, Long clientId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        clientRepository.save(client);

        company.getClients().add(client);
        return companyRepository.save(company);
    }
}
