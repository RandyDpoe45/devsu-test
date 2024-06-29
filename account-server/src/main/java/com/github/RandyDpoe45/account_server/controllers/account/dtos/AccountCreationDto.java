package com.github.RandyDpoe45.account_server.controllers.account.dtos;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountCreationDto(
        Long userId,
        String accountTypeCode,
        String accountStatusCode,
        BigDecimal initialBalance
) {
}
