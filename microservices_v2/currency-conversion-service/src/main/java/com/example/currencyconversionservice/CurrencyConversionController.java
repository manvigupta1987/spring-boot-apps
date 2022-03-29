package com.example.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
//        CurrencyConversion response = proxy.retrieveExchangeValue(from, to);
//        logger.info("{}", response);
        return new CurrencyConversion(1000L, from, to, BigDecimal.valueOf(75),
                quantity, quantity.multiply(BigDecimal.valueOf(75)), 8000);
    }
}
