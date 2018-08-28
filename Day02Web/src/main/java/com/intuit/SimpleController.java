package com.intuit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	//http://localhost:8080/hi?name=Sachin
	@GetMapping("/hi")
	@ResponseBody
	public String hi(@RequestParam("name") String name) {
		return "Hi " + name;
	}
	
	@PutMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@PostMapping("/bye/{name}")
	@ResponseBody
	public String bye(@PathVariable("name") String name) {
		return "Bye Bye " + name;
	}
	
	
	@GetMapping("/greet")
	@ResponseBody
	public String greet() {
		return "Hello there";
	}
}
