package com.intuit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalinCheckController {

	@GetMapping("/palincheck/{word}")
	public String check(@PathVariable String word) {
		try {Thread.sleep(2000);}catch(Exception ex) {};
		String[] wordArr = word.split("");
		StringBuilder reversedWord = new StringBuilder(""); 
		for (int i = wordArr.length - 1; i > -1; i--) {
			reversedWord.append(wordArr[i]);
		}
		boolean isPalin = word.equalsIgnoreCase(reversedWord.toString());
		return isPalin ? "Palindrome" : "Not a Palindrome";
	}
}
