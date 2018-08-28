package main.java.com.intuit;

import org.springframework.stereotype.Component;

@Component
public class SoundAlram implements Alarm{
    public void ring() {
        System.out.println("Sound Alarm Ringing");
    }

    public void stop() {
        System.out.println("Sound Alarm Stopped");

    }
}
