package com.ingemark.business.api.rest.client.hnb;

import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;
import com.ingemark.business.config.RestClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {RestClientConfig.class, TecajnaListaRestClientServiceImpl.class})
@ActiveProfiles("test")
public class TecajnaListaRestClientServiceTest {

    @Autowired
    private TecajnaListaRestClientServiceImpl tecajnaListaRestClientService;


    @Test
    void fetchAll() {

        TecajnaListaItem[] tecajnaLista = tecajnaListaRestClientService.fetch();
        assertNotNull(tecajnaLista);
    }

    @Test
    void fetchUSD() {

        TecajnaListaItem[] tecajnaLista = tecajnaListaRestClientService.fetch("USD");
        assertNotNull(tecajnaLista);
    }

}
