package com.intuit;

import org.springframework.stereotype.Component;

@Component
public class StatementDaoImpl extends BaseDaoSupport implements StatementDao
{
	public void addStatement(int accountNumber,String type,int amount)
	{
		String sql = "insert into statements(account_number,type,amount) values(?,?,?)";
		getJdbcTemplate().update(sql,accountNumber,type,amount);
	}
}
