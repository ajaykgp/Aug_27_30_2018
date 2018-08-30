package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class StockFinder {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@JmsListener(destination="StockQueue",containerFactory="stockFactory")
	public void receiveMessage(String symbol) {
		double price = Math.random() * 1000;
		String message = "Price of " + symbol + ": " + price;
		System.out.println(message);
	}
}
