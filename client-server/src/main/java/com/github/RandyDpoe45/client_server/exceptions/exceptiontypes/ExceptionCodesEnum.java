package com.github.RandyDpoe45.client_server.exceptions.exceptiontypes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCodesEnum {
    UNPARSEABLE_JSON("001", "Unparseable JSON"),
    UNEXPECTED_ERROR("002", "Unexpected error"),
    CLIENT_NOT_FOUND("003", "Client not found"),
    CLIENT_STATUS_NOT_FOUND("004", "Client status not found"),
    ;

    private final String code;
    private final String defaultMessage;
}
