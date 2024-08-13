package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.Client;
import com.helpdesk.mtb.help_mtb.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientInterface {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompanyService companyService;


    @Override
    public Client createClient(Client client) {
        Client clientSave = clientRepository.save(client);
        companyService.addUserToCompany(clientSave.getCompanyId(), clientSave.getId());
        return clientSave;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
