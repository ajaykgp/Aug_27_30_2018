package com.intuit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	List<Person> findByNameAndAge(String name, int age);
	List<Person> findByAgeAndName(int age, String name);
	
	@Query("select p from Person p where p.age > :p1")
	List<Person> findAllWithAgeGreaterThan(@Param("p1") int age);

}
