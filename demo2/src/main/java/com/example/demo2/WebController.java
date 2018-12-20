package com.example.demo2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    //Json format is deserialized automatically just need to use @RequestBody
    @PostMapping("/temperature")
    public String getTemperature(@RequestBody CityInfo cityInfo){
        double temp = Math.random() *100;
        return "Temperature of " + cityInfo.getCity() + " is " + temp;
    }
}
