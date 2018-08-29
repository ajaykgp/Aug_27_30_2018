package com.example.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class NormalController {
    @GetMapping("/index")
    public String start(){
        return "index";
    }

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/ispalindrome")
    @ResponseBody
    public String  start(@RequestParam String word){
//        boolean isPalindrome = true;
//        int j= word.length() - 1;
//        for (int i= 0; i<word.length()/2;i++)
//        {
//            if(word.charAt(i) !=  word.charAt(j)){
//                isPalindrome = false;
//            }
//        }
//        return isPalindrome;

        //Incase method is post
/*
        String isPlaindrome = restTemplate.postForObject("http://172.28.60.27:8080/ispalindrome?word="+word, null, String.class);
        return isPlaindrome;
 */
        String isPalindrom = restTemplate.getForObject("http://localhost:3000/palin/"+word, String.class);
        return isPalindrom;
    }

//    @PostMapping("/process")
//    @ResponseBody
//    public String processForm(@RequestParam String name){
//        return "Hello " + name;
//    }

    @PostMapping("/process")
    public String processForm(@RequestParam String name, HttpSession session){
        session.setAttribute("msg","hello"+ name);
        return "result";
    }
}
