package com.intuit;

import org.springframework.stereotype.Component;

@Component
public class StatementDaoImpl extends BaseDaoSupport implements StatementDao
{
	//INTENTIONALLY CREATE AN ERROR IN SQL
	public void addStatement(int accountNumber,String type,int amount)
	{
		String sql = "insert int statements(account_number,type,amount) values(?,?,?)";
		getJdbcTemplate().update(sql,accountNumber,type,amount);
	}
}
