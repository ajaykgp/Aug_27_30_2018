package com.intuit;

public interface StatementDao {
	void addStatement(int accountNumber,String type,int amount);
}