package main.java.com.intuit.labsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Conference {
    @Autowired
    SessionPlanner sessionPlanner;

    public void printTotalSessions(){
        System.out.println(String.format("45 min session %d",sessionPlanner.getTotalCount("45")));
        System.out.println(String.format("50 min session %d",sessionPlanner.getTotalCount("50")));
        System.out.println(String.format("60 min session %d",sessionPlanner.getTotalCount("60")));

    }
}
