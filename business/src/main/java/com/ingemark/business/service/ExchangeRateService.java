package com.ingemark.business.service;

import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;

import java.util.List;

public interface ExchangeRateService {

    List<TecajnaListaItem> fetch();
    TecajnaListaItem fetch(String valuta);
}
