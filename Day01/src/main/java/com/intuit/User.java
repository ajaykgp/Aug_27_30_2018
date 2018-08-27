package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		//Door door = DoorFactory.getDoorWithSoundAlarm();
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		Door door = context.getBean("myDoor",Door.class);
		door.open();
		door.close();
		SoundAlarm soundAlarm = context.getBean("soundAlarm",SoundAlarm.class);
	}

}
