package com.example.demo3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Second variable is the primary key of table
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
