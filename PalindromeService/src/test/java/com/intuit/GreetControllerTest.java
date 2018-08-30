package com.intuit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GreetControllerTest {

	@MockBean
	private GreetController greetController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHello() throws Exception{
		when(greetController.hello("Sam")).thenReturn("Hello Sam");
		
		mockMvc.perform(get("/hello/Sam"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello Sam"));
	}
	
	
	
	
	
	
	
	
}
