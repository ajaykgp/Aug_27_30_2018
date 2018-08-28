package com.intuit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Person> getAllPersons(){
		List<Person> persons = null;
		persons = jdbcTemplate.query("select * from persons", new RowMapper<Person>() {
			public Person mapRow(ResultSet rs, int index) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setAge(rs.getInt("age"));
				person.setName(rs.getString("name"));
				return person;
			}
		});
		return persons;
	}
	
	public List<String> getAllNames(){
		return jdbcTemplate.queryForList("select name from persons", String.class);
	}
	public void updateAge(int id,int newAge) {
		jdbcTemplate.update("update persons set age=? where id=?",newAge,id);
	}
	
	public int getAge(int id) {
		return jdbcTemplate.queryForObject("select age from persons where id=?", 
				Integer.class, id);
	}
	
	public void insert(String name,int age) {
		jdbcTemplate.update("inser into persons(name,age) values(?,?)",name,age);
	}
}
