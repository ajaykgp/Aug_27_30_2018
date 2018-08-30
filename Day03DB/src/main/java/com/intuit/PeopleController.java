package com.intuit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PeopleController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/find/greaterthan/{age}")
	public List<Person> findPersonsGreaterThan(@PathVariable int age){
		return personRepository.findAllWithAgeGreaterThan(age);
	}
	
	@GetMapping("/find/{name}/{age}")
	public List<Person> findPersons(@PathVariable String name, @PathVariable int age){
		//return personRepository.findByNameAndAge(name,age);
		return personRepository.findByAgeAndName(age,name);
	}
	
	@GetMapping("/")
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	@PutMapping("/update/{id}/{name}/{age}")
	public String updatePerson(@PathVariable int id,
			@PathVariable String name, @PathVariable int age) {
		Optional<Person> optPerson = personRepository.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			person.setAge(age);
			person.setName(name);
			personRepository.save(person);
		}
		else {
			return "Person not found";
		}
		return "Done";
	}
	@DeleteMapping("/delete/{id}")
	public String deletePerson(@PathVariable int id) {
		//personRepository.deleteById(id);
		
		Optional<Person> optPerson = personRepository.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			personRepository.delete(person);
		}
		else {
			return "Person not found";
		}
		return "Done";
	}
	@PostMapping("/save/{name}/{age}")
	public String save(@PathVariable String name,@PathVariable int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personRepository.save(person);
		return "DONE";
	}
}








