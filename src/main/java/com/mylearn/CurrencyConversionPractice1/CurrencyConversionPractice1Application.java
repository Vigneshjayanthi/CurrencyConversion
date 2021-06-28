package com.mylearn.CurrencyConversionPractice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CurrencyConversionPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionPractice1Application.class, args);
	}
	@Bean
	public RestTemplate getrestTemplate() {
	return new RestTemplate();
	}

}
