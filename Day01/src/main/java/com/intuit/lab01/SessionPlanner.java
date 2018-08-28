package com.intuit.lab01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class SessionPlanner {
	
	@Resource(name="topics")
	private Map<String, String> topics;
	
	private List<String> _60MinTopics;
	private List<String> _50MinTopics;
	private List<String> _45MinTopics;
	
	@PostConstruct 
	public void populateDurationsAndTopics(){
		_60MinTopics = new ArrayList<>();
		_50MinTopics = new ArrayList<>();
		_45MinTopics = new ArrayList<>();
		topics.forEach((topic,duration) -> {
			if(duration.contains("60"))
				_60MinTopics.add(topic);
			else if(duration.contains("50"))
				_50MinTopics.add(topic);
			else if(duration.contains("45"))
				_45MinTopics.add(topic);
		});
	}

	public List<String> get60MinTopics() {
		return _60MinTopics;
	}

	public List<String> get50MinTopics() {
		return _50MinTopics;
	}

	public List<String> get45MinTopics() {
		return _45MinTopics;
	}
	
	
}
