package com.github.RandyDpoe45.account_server.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatusEnum {
    ACTIVE("ACTIVE"),
    DISABLED("DISABLED");

    private final String code;
}
