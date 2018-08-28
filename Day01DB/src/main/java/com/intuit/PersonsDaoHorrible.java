package com.intuit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonsDaoHorrible {
	public void insert(String name,int age) throws SQLException{
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/springtraining","root","durasoft");
			Statement statement = connection.createStatement();
			statement.execute("insert into persons(name,age) values('" + name + "'," + age + ")");
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		
	}
}
