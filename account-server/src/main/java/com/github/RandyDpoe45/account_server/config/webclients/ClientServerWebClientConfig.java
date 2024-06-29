package com.github.RandyDpoe45.account_server.config.webclients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientServerWebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder authServiceWebClientBuilder() {
        return WebClient.builder()
                .baseUrl("lb://CLIENT-SERVER")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    }
}
