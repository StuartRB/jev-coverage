package com.example.jevcoverage.config;

import com.example.jevcoverage.properties.JevProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient jevRestClient(JevProperties properties) {
        return RestClient.builder()
                .baseUrl(properties.getUrl() + properties.getPath())
                .defaultHeader("Authorization", "Bearer " + properties.getApiKey())
                .build();
    }
}
