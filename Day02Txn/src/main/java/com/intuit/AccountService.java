package com.intuit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public  class AccountService
{
	@Autowired
	@Resource(name="accountDaoImpl")
	private AccountDao accountDao;
	@Autowired
	private StatementDao statementDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	public void deposit(int accountNumber,String type, int amount) {
		transactionTemplate.execute(new TransactionCallback<Boolean>() {
			public Boolean doInTransaction(TransactionStatus txnStatus) {
				try {
					accountDao.deposit(accountNumber, amount);
					statementDao.addStatement(accountNumber, type, amount);
				}
				catch(Exception ex) {
					txnStatus.setRollbackOnly();
				}
				return true;
			}

		});
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=AccountServiceException.class)
	public void withdraw(int accountNumber,String type, int amount)throws AccountServiceException
	{
		accountDao.withdraw(accountNumber, amount);
		int i = 10;
		if(i % 2 == 0) {
			throw new AccountServiceException();
		}
		statementDao.addStatement(accountNumber, type, amount);
	}
}





