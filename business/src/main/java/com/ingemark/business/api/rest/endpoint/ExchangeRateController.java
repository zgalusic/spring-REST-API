package com.ingemark.business.api.rest.endpoint;

import com.ingemark.business.api.rest.client.hnb.model.TecajnaListaItem;
import com.ingemark.business.service.ExchangeRateService;
import com.ingemark.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rest/exchange-rate", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeRateController {

    private final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateController.class);

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ResponseWrapper<List<TecajnaListaItem>> fetch() {

        LOGGER.info("Fetching exchange rate");

        List<TecajnaListaItem> tecajnaListaItemList = exchangeRateService.fetch();

        ResponseWrapper<List<TecajnaListaItem>> exchangeRateResponseWrapper = new ResponseWrapper<>();
        exchangeRateResponseWrapper.setData(tecajnaListaItemList);

        return exchangeRateResponseWrapper;
    }

    @GetMapping("{valuta}")
    public ResponseWrapper<TecajnaListaItem> fetch(@PathVariable String valuta) {

        LOGGER.info("Fetching exchange rate for currency: {}", valuta);

        TecajnaListaItem tecajnaListaItem = exchangeRateService.fetch(valuta);

        ResponseWrapper<TecajnaListaItem> exchangeRateResponseWrapper = new ResponseWrapper<>();
        exchangeRateResponseWrapper.setData(tecajnaListaItem);

        return exchangeRateResponseWrapper;
    }
}
