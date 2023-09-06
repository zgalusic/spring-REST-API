package com.ingemark.business.api.rest.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/rest/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
}
