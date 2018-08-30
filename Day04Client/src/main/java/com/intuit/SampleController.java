package com.intuit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/index")
	public String start() {
		return message;
	}
}
