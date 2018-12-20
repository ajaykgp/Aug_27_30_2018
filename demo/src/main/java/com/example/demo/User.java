package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
        PersonDao personDao = context.getBean("personDao", PersonDao.class);
        personDao.insert("cherry",12);
        personDao.insert("nitu",12);
        System.out.println("success");
        System.out.println(personDao.getAllNames());
        System.out.println(personDao.getAge(1));
        personDao.updateAge(1,26);
        System.out.println(personDao.getAllNames());



    }
}
