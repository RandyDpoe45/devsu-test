package com.wesdom.gatewayrouter.config;

import com.wesdom.gatewayrouter.config.properties.RoutingProperties;
import com.wesdom.gatewayrouter.config.properties.ServiceRoute;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

    private final RoutingProperties routingProperties;

    public RoutingConfiguration(
            RoutingProperties routingProperties
    ) {
        this.routingProperties = routingProperties;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder aux = builder.routes();
        for (var entry : routingProperties.getServices().entrySet()) {
            for (ServiceRoute route : entry.getValue().getRoutes()) {
                System.out.println(entry.getValue().getPrefix()+route.getPath());
                aux = aux.route(
                        route.getId(),
                        r -> r.path(entry.getValue().getPrefix()+route.getPath())
                                .filters(f -> {
                                    return f.stripPrefix(1);
                                })
                                .uri(String.format(entry.getValue().getServiceUrl()))
                );
            }
        }
        return aux.build();
    }
}
