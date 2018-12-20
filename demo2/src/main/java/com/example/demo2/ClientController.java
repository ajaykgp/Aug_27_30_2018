package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${temperature.service.url}")
    private String baseUrl;

    @GetMapping("/getinfocity/{city}/{state}")
    public ResponseEntity getInfoCity(@PathVariable String city, @PathVariable String state){
            MultiValueMap<String, String> headers = new LinkedMultiValueMap();
            headers.add("content-type", "application/json");

            Map<String, String> body = new HashMap<>();
            body.put("city", city);
            body.put("state", state);

            HttpEntity<?> request =  new HttpEntity<>(body,headers);

            return restTemplate.postForEntity(baseUrl, request, String.class);
    }
}
