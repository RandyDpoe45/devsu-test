package com.github.RandyDpoe45.client_server.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientStatusEnum {

    ACTIVE("ACTIVE"),
    DISABLED("DISABLED");

    private final String code;
}
