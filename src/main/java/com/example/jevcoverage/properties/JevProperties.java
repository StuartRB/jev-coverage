package com.example.jevcoverage.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "jev")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class JevProperties {
    private String url;
    private String apiKey;
    private String path;
}
