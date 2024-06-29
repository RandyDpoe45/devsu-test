package com.github.RandyDpoe45.client_server.services.implementations;

import com.github.RandyDpoe45.client_server.controllers.client.dtos.ClientDto;
import com.github.RandyDpoe45.client_server.exceptions.exceptiontypes.ClientServiceException;
import com.github.RandyDpoe45.client_server.exceptions.exceptiontypes.ExceptionCodesEnum;
import com.github.RandyDpoe45.client_server.persistence.jparepositories.ClientJpaRepository;
import com.github.RandyDpoe45.client_server.persistence.jparepositories.ClientStatusJpaRepository;
import com.github.RandyDpoe45.client_server.persistence.model.Client;
import com.github.RandyDpoe45.client_server.persistence.model.ClientStatus;
import com.github.RandyDpoe45.client_server.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientStatusJpaRepository clientStatusJpaRepository;

    @Override
    public List<Client> getAllClients() {
        return clientJpaRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientJpaRepository.findById(id)
                .orElseThrow(() -> new ClientServiceException(ExceptionCodesEnum.CLIENT_NOT_FOUND));
    }

    @Override
    public Client createClient(ClientDto clientDto) {
        ClientStatus clientStatus = getClientStatus(clientDto.clientStatusCode());
        Client client = (Client) new Client()
                .setClientStatus(clientStatus)
                .setPassword(clientDto.password())
                .setAge(clientDto.age())
                .setAddress(clientDto.address())
                .setFirstName(clientDto.firstName())
                .setIdentification(clientDto.identification())
                .setTelephoneNumber(clientDto.telephoneNumber());

        client = clientJpaRepository.saveAndFlush(client);
        return client;
    }

    @Override
    public Client updateClient(Long id, ClientDto clientDto) {
        Client client = getClientById(id);
        ClientStatus clientStatus = getClientStatus(clientDto.clientStatusCode());
        client.setClientStatus(clientStatus)
                .setPassword(clientDto.password())
                .setAge(clientDto.age())
                .setAddress(clientDto.address())
                .setFirstName(clientDto.firstName())
                .setIdentification(clientDto.identification())
                .setTelephoneNumber(clientDto.telephoneNumber());
        client = clientJpaRepository.saveAndFlush(client);
        return client;
    }

    private ClientStatus getClientStatus(String clientStatusCode) {
        ClientStatus clientStatus = clientStatusJpaRepository.findByCode(clientStatusCode);
        if (Objects.isNull(clientStatus))
            throw new ClientServiceException(ExceptionCodesEnum.CLIENT_STATUS_NOT_FOUND);
        return clientStatus;
    }

    @Override
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientJpaRepository.delete(client);
    }
}
