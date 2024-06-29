package com.wesdom.gatewayrouter.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class ServiceRouting {

    private String serviceUrl;
    private String resourceName;
    private String prefix;
    private List<ServiceRoute> routes;
}
