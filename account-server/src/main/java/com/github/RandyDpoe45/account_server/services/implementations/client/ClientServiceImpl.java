package com.github.RandyDpoe45.account_server.services.implementations.client;

import com.github.RandyDpoe45.account_server.services.interfaces.client.ClientService;
import com.github.RandyDpoe45.account_server.services.interfaces.client.ClientDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {

    private final WebClient.Builder clientServerWebClient;

    public ClientServiceImpl(
            @Qualifier("authServiceWebClientBuilder")
            WebClient.Builder clientServerWebClient
    ) {
        this.clientServerWebClient = clientServerWebClient;
    }

    @Override
    public ClientDto getClientById(Long id) {
        return clientServerWebClient.build()
                .get()
                .uri("/client/{id}", Map.of("id", id))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ClientDto.class)
                .share()
                .block();
    }
}
