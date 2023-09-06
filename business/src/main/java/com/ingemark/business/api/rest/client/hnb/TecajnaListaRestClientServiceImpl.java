package com.ingemark.business.api.rest.client.hnb;

import com.ingemark.business.api.rest.client.RestClient;
import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TecajnaListaRestClientServiceImpl extends RestClient implements TecajnaListaRestClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TecajnaListaRestClientServiceImpl.class);

    @Value("${api.hnb.hr.url}")
    private String baseURL;

    protected TecajnaListaRestClientServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public TecajnaListaItem[] fetch() {

        LOGGER.info("Dohvat cijele tečajne liste.");

        return executeGet(baseURL, TecajnaListaItem[].class);
    }

    @Override
    public TecajnaListaItem[] fetch(String valuta) {

        LOGGER.info("Dohvat tečajne liste za valutu {}.", valuta);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseURL);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add(QueryParameter.VALUTA.getName(), valuta);
        uriComponentsBuilder.queryParams(params);
        String url = uriComponentsBuilder.build().toUriString();

        return executeGet(url, TecajnaListaItem[].class);
    }
}
