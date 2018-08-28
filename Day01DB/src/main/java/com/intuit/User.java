package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class User {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		PersonsDao dao = context.getBean("personsDao",PersonsDao.class);
		try {
			dao.insert("Sam", 12);
		} catch (DataAccessException e) {
			System.out.println("Error " + e.getCause());
		}
		System.out.println("success");
	}

}
