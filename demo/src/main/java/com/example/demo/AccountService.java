package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public  class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private StatementDao statementDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    //Programmatic was of coding
    public void deposit(int accountNumber,String type, int amount) {

        transactionTemplate.execute(new TransactionCallback<Boolean>() {
             public Boolean doInTransaction(TransactionStatus transactionStatus){
                 try {
                     accountDao.deposit(accountNumber,amount);
                     statementDao.addStatement(accountNumber,type,amount);
                 } catch (Exception ex){
                     transactionStatus.setRollbackOnly();
                 }
                 return true;
             }
        });

    }

    //Declarative way of coding
    @Transactional
    public void withdraw(int accountNumber,String type, int amount) {
        accountDao.withdraw(accountNumber,amount);
        statementDao.addStatement(accountNumber,type,amount);
    }
}
