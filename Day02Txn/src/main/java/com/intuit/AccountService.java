package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService
{
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private StatementDao statementDao;
	
	public void deposit(int accountNumber,String type, int amount) {
		accountDao.deposit(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
	public void withdraw(int accountNumber,String type, int amount)
	{
		accountDao.withdraw(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
}