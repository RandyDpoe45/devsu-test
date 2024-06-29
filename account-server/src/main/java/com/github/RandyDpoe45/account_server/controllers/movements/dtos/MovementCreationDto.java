package com.github.RandyDpoe45.account_server.controllers.movements.dtos;


import java.math.BigDecimal;

public record MovementCreationDto(
        String accountNumber,
        BigDecimal amount
) {
}
