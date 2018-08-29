package com.intuit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountsController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/deposit")
	public String deposit(@RequestParam("accountnumber") int accountNumber, 
			@RequestParam int amount, @RequestParam String type) {
		boolean deposited = accountService.deposit(accountNumber, amount, type);
		if(deposited)
			return "Deposited successfully";
		return "Unable to deposit";
	}
	
	@PostMapping("/withdraw")
	public String withdraw(@RequestParam("accountnumber") int accountNumber, 
			@RequestParam int amount, @RequestParam String type) {
		boolean withdrawn = accountService.withdraw(accountNumber, amount, type);
		if(withdrawn)
			return "Withdraw success";
		return "Unable to withdraw";
	}
}
