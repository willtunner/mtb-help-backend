package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.Client;
import com.helpdesk.mtb.help_mtb.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientInterface {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}
