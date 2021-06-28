package com.mylearn.CurrencyConversionPractice1.bean;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal currencyValue;
	private BigDecimal qunas;
	private BigDecimal getCurrentValue;
	
	
	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversion(Long id, String from, String to, BigDecimal currencyValue, BigDecimal qunas,
			BigDecimal getCurrentValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyValue = currencyValue;
		this.qunas = qunas;
		this.getCurrentValue = getCurrentValue;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}
	public BigDecimal getQunas() {
		return qunas;
	}
	public void setQunas(BigDecimal qunas) {
		this.qunas = qunas;
	}
	public BigDecimal getGetCurrentValue() {
		return getCurrentValue;
	}
	public void setGetCurrentValue(BigDecimal getCurrentValue) {
		this.getCurrentValue = getCurrentValue;
	}
	
	
	

}
