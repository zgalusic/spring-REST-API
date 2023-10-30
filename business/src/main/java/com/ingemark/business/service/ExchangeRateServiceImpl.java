package com.ingemark.business.service;

import com.ingemark.business.api.rest.client.hnb.TecajnaListaRestClientService;
import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final TecajnaListaRestClientService tecajnaListaRestClientService;

    public ExchangeRateServiceImpl(TecajnaListaRestClientService tecajnaListaRestClientService) {
        this.tecajnaListaRestClientService = tecajnaListaRestClientService;
    }

    @Override
    public List<TecajnaListaItem> fetch() {

        TecajnaListaItem[] tecajnaListaItems = tecajnaListaRestClientService.fetch();

        return List.of(tecajnaListaItems);
    }

    @Override
    public TecajnaListaItem fetch(String valuta) {

        TecajnaListaItem[] tecajnaListaItems = tecajnaListaRestClientService.fetch(valuta);

        return tecajnaListaItems[0];
    }
}
