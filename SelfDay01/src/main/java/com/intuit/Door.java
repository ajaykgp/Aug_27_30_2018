package main.java.com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Door {

    @Autowired
    Alarm alarm;

    public void open(){
        alarm.ring();
    }

    public void close(){
        alarm.stop();
    }
}
