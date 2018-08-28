package com.intuit;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public double add(double num1,double num2) {
		return num1 + num2;
	}
	
	public double subtract(double num1,double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1,double num2) {
		return num1 * num2;
	}
	
	public double square(double num) {
		return num * num;
	}
}
