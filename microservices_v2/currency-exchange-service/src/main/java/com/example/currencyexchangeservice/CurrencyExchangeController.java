package com.example.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;
	
//	@Autowired
//	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue
		(@PathVariable String from, @PathVariable String to){
		
//		ExchangeValue exchangeValue =
//				repository.findByFromAndTo(from, to);

		ExchangeValue exchangeValue = new ExchangeValue(1l, from, to, BigDecimal.valueOf(75));
		String port = environment.getProperty("local.server.port");
		exchangeValue.setEnvironment(port);
		
//		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
}
