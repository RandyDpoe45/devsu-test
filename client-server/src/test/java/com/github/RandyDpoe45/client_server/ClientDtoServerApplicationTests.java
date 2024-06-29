package com.github.RandyDpoe45.client_server;

import com.github.RandyDpoe45.client_server.controllers.client.dtos.ClientDto;
import com.github.RandyDpoe45.client_server.persistence.enums.ClientStatusEnum;
import com.github.RandyDpoe45.client_server.persistence.model.Client;
import com.github.RandyDpoe45.client_server.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientDtoServerApplicationTests {


    @Autowired
    private ClientService clientService;

    @Test
    void contextLoads() {
        Client client = clientService.createClient(new ClientDto(
                "Darrell",
                18,
                "123456",
                "Carrera 20 # 15 - 40",
                "3214095273",
                "123456",
                "ACTIVE"
        ));
		assert client.getClientStatus().getCode().equals(ClientStatusEnum.ACTIVE.getCode());
    }

}
