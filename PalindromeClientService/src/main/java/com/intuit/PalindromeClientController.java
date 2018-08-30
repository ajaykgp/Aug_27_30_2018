package com.intuit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PalindromeClientController {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/palin/{word}")
	public String checkPalindromeFromAnotherServer(@PathVariable String word) {
		String url = "http://localhost:7001/palincheck/" + word;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
	}
}
