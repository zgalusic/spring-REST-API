package com.ingemark.business.api.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class RestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    private final RestTemplate restTemplate;

    protected RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected <U> U executeGet(String url, Class<U> clazz) {

        LOGGER.info("HTTP GET {}", url);

        try {

            return restTemplate.getForObject(url, clazz);

        } catch (Exception e) {

            throw new RestClientGeneralException(e);
        }
    }
}
