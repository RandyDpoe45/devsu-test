package com.github.RandyDpoe45.account_server.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnum {
    SAVINGS("SAVINGS"),
    CHECKING("CHECKING"),;
    private final String code;
}
