package com.intuit.concepts;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
public class Person {
	public Person() {
		System.out.println("Person created");
	}
}
