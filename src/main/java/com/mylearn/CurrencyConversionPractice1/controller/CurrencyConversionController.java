package com.mylearn.CurrencyConversionPractice1.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mylearn.CurrencyConversionPractice1.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private RestTemplate resttemplate;
	
	@GetMapping("currency-converison/from/{from}/to/{to}/quantity/{quan}")
	public CurrencyConversion getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quan) {
		HashMap<String, String> hashmapvalue = new HashMap<String, String>();
		hashmapvalue.put("from", from);
		hashmapvalue.put("to", to);
		ResponseEntity<CurrencyConversion> responseCurrency =  resttemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
				, CurrencyConversion.class,hashmapvalue);
		CurrencyConversion conver = responseCurrency.getBody();
		return new CurrencyConversion(conver.getId(),conver.getFrom(),conver.getTo(),conver.getCurrencyValue(),quan,quan.multiply(conver.getCurrencyValue()));
		
	}
	@GetMapping("currency-conversion/allvalue/quantity/{quan}")
	public List<CurrencyConversion> getAllCurrencyConersion(@PathVariable BigDecimal quan){
		ResponseEntity<CurrencyConversion[]> listcurrency = resttemplate.getForEntity("http://localhost:8000/currency-exchange/AllValue",
				CurrencyConversion[].class );
		CurrencyConversion [] lisObjects= listcurrency.getBody();
		List<CurrencyConversion> allcurrrecny= new ArrayList<CurrencyConversion>();
		for(CurrencyConversion ob:lisObjects) {
			CurrencyConversion individual = new CurrencyConversion(ob.getId(),ob.getFrom(),ob.getTo(),ob.getCurrencyValue(),quan,quan.multiply(ob.getCurrencyValue()));
			allcurrrecny.add(individual);
		}
		return allcurrrecny;
		
	}
	@GetMapping("currecny-conversion/allvalue")
	public List<CurrencyConversion> getCurrencyWithoutQunatity(){
		ResponseEntity<CurrencyConversion[]> listOfCurrency = resttemplate.getForEntity("http://localhost:8000/currency-exchange/AllValue", 
				CurrencyConversion[].class);
		CurrencyConversion[] objectValue = listOfCurrency.getBody();
		List<CurrencyConversion> listCurrencyValue = new ArrayList<CurrencyConversion>();
		for(CurrencyConversion cc:objectValue) {
			CurrencyConversion individualValue= new CurrencyConversion(cc.getId(),cc.getFrom(),cc.getTo(),cc.getCurrencyValue(),BigDecimal.ZERO,BigDecimal.ZERO);
			listCurrencyValue.add(individualValue);
		}
		return listCurrencyValue;
	}

}
