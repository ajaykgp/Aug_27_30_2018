package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save/{name}/{age}")
    public String save(@PathVariable String name, @PathVariable int age){
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return "DONE";
    }

    @PutMapping("/update/{id}/{name}/{age}")
    public String update(@PathVariable int id,@PathVariable String name, @PathVariable int age){
        Person person = personRepository.getOne(id);
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return "DONE";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Person person = personRepository.getOne(id);
        personRepository.delete(person);
        return "DONE";
    }

    @GetMapping("/")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
}
