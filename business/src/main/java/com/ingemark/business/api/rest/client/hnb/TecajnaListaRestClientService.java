package com.ingemark.business.api.rest.client.hnb;

import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;

public interface TecajnaListaRestClientService {

    TecajnaListaItem[] fetch();
    TecajnaListaItem[] fetch(String valuta);
}
