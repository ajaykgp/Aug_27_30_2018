package com.example.demo2;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int add(int a, int b){
        return  a + b;
    }
    public double square(int a){
        return  Math.pow(a,2);
    }
    public int subtract(int a, int b){
        return  a - b;
    }
    public int product(int a, int b){
        return  a * b;
    }

}
