package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllNames(){
        return  jdbcTemplate.queryForList("select name from persons", String.class);
    }

    public void updateAge(int id, int newAge){
        jdbcTemplate.update("update persons set age=? where id=?",  newAge, id);
    }

    public int getAge(int id){
        return jdbcTemplate.queryForObject("select age from persons where id=?", Integer.class, id);
    }


    public void insert(String name, int age) {
        jdbcTemplate.update("insert into persons(name,age) value(?,?)", name,  age);
    }
}
