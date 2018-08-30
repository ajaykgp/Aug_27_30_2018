package com.intuit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class PalindromeClientController {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/palin/{word}")
	@HystrixCommand(fallbackMethod="checkPalindromeCache",commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",
					value="5000")
	})
	public String checkPalindromeFromAnotherServer(@PathVariable String word) {
		System.out.println("In the actual method");
		String url = "http://localhost:7001/palincheck/" + word;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
	}
	
	public String checkPalindromeCache(String word) {
		System.out.println("*****In the fallback method");
		return "Response from cache: The service is down. Please try later";
	}
	
	
	
	
	
	
	
	
}
