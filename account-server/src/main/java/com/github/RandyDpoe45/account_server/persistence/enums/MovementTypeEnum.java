package com.github.RandyDpoe45.account_server.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovementTypeEnum {
    WITHDRAWAL("WITHDRAWAL"),
    DEPOSIT("DEPOSIT");
    private final String code;
}
