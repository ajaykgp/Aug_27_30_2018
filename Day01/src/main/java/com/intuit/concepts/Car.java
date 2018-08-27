package com.intuit.concepts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
	//@Value("BMW")
	@Value("${company}")
	private String model;
	
	@Resource(name="carowners")
	private List<String> owners;
	
	public List<String> getOwners() {
		return owners;
	}



	public String getModel() {
		return this.model;
	}
}
