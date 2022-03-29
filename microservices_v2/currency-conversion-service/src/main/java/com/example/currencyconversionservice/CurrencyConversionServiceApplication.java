package com.example.currencyconversionservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients("com.example.currencyconversionservice") // package that you want figen to scan
//@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
//	@Bean
//	public Sampler defaultSampler() {
//		return Sampler.ALWAYS_SAMPLE;
//	}
}
