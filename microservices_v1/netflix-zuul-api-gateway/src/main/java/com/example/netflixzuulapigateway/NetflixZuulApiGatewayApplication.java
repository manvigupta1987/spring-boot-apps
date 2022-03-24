package com.example.netflixzuulapigateway;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}


// urls that we run:
// 1. http://localhost:8765/currency-conversion-service/currency-conveter/from/EUR/to/INR/quantity/10000 --> if we want all the request to through Api gateway. <app-name>/<uri>
// 2. http://localhost:8100/currency-conveter/from/EUR/to/INR/quantity/10000 -- >when we want to interact with currency exchange service through API gateway.
