package com.wesdom.gatewayrouter;

import com.wesdom.gatewayrouter.config.properties.RoutingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableConfigurationProperties({RoutingProperties.class})
public class GatewayRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayRouterApplication.class, args);
	}

}
