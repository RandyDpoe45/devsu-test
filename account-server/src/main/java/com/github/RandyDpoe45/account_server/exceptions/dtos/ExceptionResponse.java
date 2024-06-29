package com.github.RandyDpoe45.account_server.exceptions.dtos;

import lombok.Builder;

@Builder
public record ExceptionResponse(
        String response,
        String exceptionCode
) {
}
