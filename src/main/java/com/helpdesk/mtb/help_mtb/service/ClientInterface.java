package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.Client;

import java.util.List;

public interface ClientInterface {
    Client createClient(Client client);

    List<Client> getAllClients();
}
