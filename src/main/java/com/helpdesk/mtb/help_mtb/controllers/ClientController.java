package com.helpdesk.mtb.help_mtb.controllers;

import com.helpdesk.mtb.help_mtb.model.Client;
import com.helpdesk.mtb.help_mtb.service.ClientService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client) throws MessagingException {
        return clientService.createClient(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}
