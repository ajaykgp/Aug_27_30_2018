package main.java.com.intuit.labsession;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;

@Component
public class SessionPlanner {
    @Resource(name="sessionsList")
    HashMap<String,String> sessionMapper;

    //Constructor will be called even before injection hence sessionMap will empty;

    @PostConstruct
    public void populateDurationsAndTopics(){
        System.out.println(sessionMapper);
//        sessionMapper.forEach((name,value)->{
//            if
//        });
    }

    public int getTotalCount(String sessionTime){
        int count = 0 ;
        for (String session:sessionMapper.values()){
            if(session.split(" ")[0].equals(sessionTime)){
                count++;
            }
        }
        return count;
    }

}
