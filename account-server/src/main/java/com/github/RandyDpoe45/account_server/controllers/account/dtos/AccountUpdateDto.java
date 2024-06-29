package com.github.RandyDpoe45.account_server.controllers.account.dtos;

import lombok.Builder;

@Builder
public record AccountUpdateDto(
        String accountTypeCode,
        String accountStatusCode
) {
}
