package com.wesdom.gatewayrouter.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;


@Getter
@Setter
@Accessors(chain = true)
@ConfigurationProperties(prefix = "router-properties")
@ToString
public class RoutingProperties {

    private Map<String, ServiceRouting> services;

}
