package com.intuit.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Lab01Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:lab01.xml");
		Conference conference = context.getBean("conference",Conference.class);
		System.out.println(String.format("60 min topics: %d", conference.get60MinTopicsCount()));
		System.out.println(String.format("50 min topics: %d", conference.get50MinTopicsCount()));
		System.out.println(String.format("45 min topics: %d", conference.get45MinTopicsCount()));
	}

}
