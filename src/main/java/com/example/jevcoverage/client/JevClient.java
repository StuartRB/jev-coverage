package com.example.jevcoverage.client;

import com.example.jevcoverage.model.JevRequest;
import com.example.jevcoverage.model.JevResponse;
import com.example.jevcoverage.properties.JevProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@AllArgsConstructor
public class JevClient {

    private RestClient jevRestClient;
    private JevProperties properties;

    public JevResponse getCoverageDecision(JevRequest request) {
        return jevRestClient.post()
                .body(request)
                .retrieve()
                .body(JevResponse.class);
    }
}
