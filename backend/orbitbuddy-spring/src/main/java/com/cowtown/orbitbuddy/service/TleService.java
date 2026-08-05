package com.cowtown.orbitbuddy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TleService {

    private final RestClient client;

    public TleService(@Value("${celestrak.api.base-url}" )String baseUrl) {
        this.client = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public String fetchTleData() {
        return client.get()
                .uri("/NORAD/elements/gp.php?GROUP=stations&FORMAT=tle")
                .retrieve()
                .body(String.class); // Plain text response
    }
}
