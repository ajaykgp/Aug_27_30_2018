package com.intuit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WedController {
	
	@PostMapping("/temperature")
	public String getTemperature(@RequestBody CityInfo cityInfo) {
		double temperature = Math.random() * 100;
		return "Temperature of " + cityInfo.getCity() + " is " + temperature;
	}
}
