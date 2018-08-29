package com.intuit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;
	private String baseUrl = "http://localhost:8080/temperature";
	
	@GetMapping("/temperature/{city}/{state}")
	public String fetchTemperatureFromAnotherServer(@PathVariable String city, 
			@PathVariable String state) {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap();
		headers.add("content-type", "application/json");
		
		Map<String,String> body = new HashMap<>();
		body.put("city", city);
		body.put("state", state);
		HttpEntity<?> request = new HttpEntity(body,headers);
		
		ResponseEntity<String> responseEntity = 
				restTemplate.postForEntity(baseUrl, request, String.class);
		String output = responseEntity.getBody();
		return output;
	}
	
}
