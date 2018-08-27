package com.intuit.concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConceptsMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:concepts.xml");
		
		Car car1 = context.getBean("car",Car.class);
		System.out.println(car1.getModel());
		System.out.println(car1.getOwners());
		
//		Person person1 = context.getBean("person",Person.class);
//		System.out.println(person1);
//		
//		Person person2 = context.getBean("person",Person.class);
//		System.out.println(person2);
//		
//		Person person3 = context.getBean("person",Person.class);
//		System.out.println(person3);
	}

}
