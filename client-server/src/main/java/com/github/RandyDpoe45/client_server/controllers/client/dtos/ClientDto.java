package com.github.RandyDpoe45.client_server.controllers.client.dtos;

public record ClientDto(
        String firstName,
        Integer age,
        String identification,
        String address,
        String telephoneNumber,
        String password,
        String clientStatusCode
) {
}
