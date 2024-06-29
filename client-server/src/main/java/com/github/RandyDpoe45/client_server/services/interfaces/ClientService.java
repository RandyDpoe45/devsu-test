package com.github.RandyDpoe45.client_server.services.interfaces;

import com.github.RandyDpoe45.client_server.controllers.client.dtos.ClientDto;
import com.github.RandyDpoe45.client_server.persistence.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client createClient(ClientDto client);

    Client updateClient(Long id, ClientDto client);

    void deleteClient(Long id);
}
