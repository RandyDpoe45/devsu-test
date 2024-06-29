package com.github.RandyDpoe45.account_server.services.interfaces.client;

import lombok.*;

@Builder
public record ClientDto(
        Long id,
        String firstName,
        Integer age,
        String identification,
        String address,
        String telephoneNumber,
        String password
) {

}
