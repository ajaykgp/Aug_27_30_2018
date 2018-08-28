package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		AccountService accountService = context.getBean("accountService",AccountService.class);
		accountService.deposit(1, "Salary", 10000);
		accountService.deposit(1, "Bonus", 1000);
		accountService.withdraw(1, "Interest", 1);
		System.out.println("Done");
	}

}
