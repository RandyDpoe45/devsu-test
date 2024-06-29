package com.github.RandyDpoe45.account_server.exceptions.exceptiontypes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCodesEnum {
    UNPARSEABLE_JSON("001", "Unparseable JSON"),
    UNEXPECTED_ERROR("002", "Unexpected error"),
    ACCOUNT_NOT_FOUND("003", "Account not found"),
    ACCOUNT_TYPE_NOT_FOUND("004", "Account type not found"),
    ACCOUNT_STATUS_NOT_FOUND("005", "Account status not found"),
    MOVEMENT_TYPE_NOT_FOUND("006", "Movement type not found"),
    CLIENT_NOT_FOUND("007", "Client not found"),
    MOVEMENT_NOT_FOUND("008", "Movement not found"),
    INSUFFICIENT_FUNDS("009", "Insufficient Funds"),;

    private final String code;
    private final String defaultMessage;
}
