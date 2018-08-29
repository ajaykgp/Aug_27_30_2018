package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleController {

    @Autowired
    Calculator calc;

    @GetMapping("/greet")
    @ResponseBody
    public String greet(){
        return "Hello there";
    }


    @GetMapping("/bye/{name}")
    @ResponseBody
    public String bye(@PathVariable("name")String name) {
        return "Bye Bye " + name;
    }

    //http://localhost:8080/hi?name=Sachin
    @GetMapping("/hi")
    @ResponseBody
    public String hi(@RequestParam("name") String name ){
        return "Hi " + name;
    }

    @PutMapping("/put/{name}")
    public String put(@PathVariable("name") String name){
        return "hi" + name;
    }

    @PostMapping("/post/{name}")
    public String post(@PathVariable("name") String name){
        return "hi" + name;
    }


    @GetMapping("/calc/add/{num1}/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1 , @PathVariable int num2) {
        return calc.add(num1,num2) ;
    }

    @GetMapping("/calc/square/{num1}")
    @ResponseBody
    public double sqaure(@PathVariable int num1 ){
        return calc.square(num1);
    }

}
