package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="myDoor")
public class Door {
	
	@Autowired
	private Alarm alarm;
	
	public void open() {
		alarm.activate();
	}
	public void close() {
		alarm.deactivate();
	}
}
