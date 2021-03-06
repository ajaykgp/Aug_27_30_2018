package com.intuit;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody

@RestController
@RequestMapping("/calc")
public class CalcController {

	@Autowired
	private Calculator calculator;

	@Autowired
	private List<String> mathOperations;
	
	@GetMapping("/mathinfo")
	public Math getMathInfo() {
		Math math = new Math();
		math.setOperation("addition");
		math.setOperands(Arrays.asList(12.2,34.5));
		return math;
	}
	
	@GetMapping("/ops")
	public List<String> getAllOperations(){
		return mathOperations;
	}
	
	@GetMapping("/add/{a}/{b}")
	public double add(@PathVariable double a, @PathVariable double b) {
		return calculator.add(a, b);
	}
	
	@GetMapping("/square/{a}")
	public double square(@PathVariable double a) {
		return calculator.square(a);
	}
	
	@PutMapping("/subtract/{a}/{b}")
	public double subtract(@PathVariable double a, @PathVariable double b) {
		return calculator.subtract(a, b);
	}
	
	@PostMapping("/product")
	public double product(@RequestParam("num1") double a, @RequestParam("num2") double b) {
		return calculator.multiply(a, b);
	}
	
	
}
