package main.java.com.intuit.labsession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:bean.xml");
        Conference conference = applicationContext.getBean("conference",Conference.class);
        conference.printTotalSessions();
    }
}
