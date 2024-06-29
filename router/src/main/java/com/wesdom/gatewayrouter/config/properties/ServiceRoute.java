package com.wesdom.gatewayrouter.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class ServiceRoute {

    private static Long idAux = 1L;

    private String id;

    private String path;

    public ServiceRoute() {
        this.id = RandomStringUtils.randomAlphanumeric(9) + idAux;
        idAux++;
    }
}
