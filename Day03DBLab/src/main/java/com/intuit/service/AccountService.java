package com.intuit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.dao.AccountRepository;
import com.intuit.dao.StatementRepository;
import com.intuit.domain.Account;
import com.intuit.domain.Statement;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private StatementRepository statementRepository;
	
	@Transactional
	public boolean deposit(int accountNumber,int amount,String type) {
		Optional<Account> optAccount = accountRepository.findById(accountNumber);
		if(optAccount.isPresent()) {
			Account account = optAccount.get();
			account.setBalance(account.getBalance() + amount);
			accountRepository.save(account);
			saveStatement(accountNumber, amount, type);
		}
		else {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean withdraw(int accountNumber,int amount,String type) {
		Optional<Account> optAccount = accountRepository.findById(accountNumber);
		if(optAccount.isPresent()) {
			Account account = optAccount.get();
			account.setBalance(account.getBalance() - amount);
			accountRepository.save(account);
			saveStatement(accountNumber, amount, type);
		}
		else {
			return false;
		}
		return true;
	}
	
	private void saveStatement(int accountNumber, int amount, String type) {
		Statement statement = new Statement();
		statement.setAccountNumber(accountNumber);
		statement.setAmount(amount);
		statement.setType(type);
		statementRepository.save(statement);
	}
	
}
