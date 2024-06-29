package com.github.RandyDpoe45.client_server.exceptions.dtos;

import lombok.Builder;

@Builder
public record ExceptionResponse(
        String response,
        String exceptionCode
) {
}
