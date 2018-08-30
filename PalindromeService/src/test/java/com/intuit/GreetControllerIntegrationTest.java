package com.intuit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class GreetControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void testHelloName() {
		String url = "/hello/Sam";
		ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);
		assertTrue("Hello Sam".equals(response.getBody()));
	}
}
