package com.github.RandyDpoe45.client_server.controllers.client.controllers;

import com.github.RandyDpoe45.client_server.controllers.client.dtos.ClientDto;
import com.github.RandyDpoe45.client_server.persistence.model.Client;
import com.github.RandyDpoe45.client_server.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
