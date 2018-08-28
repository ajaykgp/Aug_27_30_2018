package com.intuit.lab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Conference {
	@Autowired
	private SessionPlanner sessionPlanner;
	
	public int get60MinTopicsCount() {
		return sessionPlanner.get60MinTopics().size();
	}
	public int get50MinTopicsCount() {
		return sessionPlanner.get50MinTopics().size();
	}
	public int get45MinTopicsCount() {
		return sessionPlanner.get45MinTopics().size();
	}
}
