package com.example.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "netflix-zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
    // this change is required to connect the zuul gateway to the currency conversion service
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to);
}
