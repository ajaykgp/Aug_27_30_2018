####For Transactions

* Create a SQL syntax error in **StatementDaoImpl** *addStatement* method
* Call **withdraw** method from **User** and check your database
* You'll notice changes in **accounts** table, but no changes to the **statements** table

#### *withdraw* method is now a recipe to apply transaction

* Transaction services
* commit or rollback
* Draw boundaries
* Specify where to begin a transaction and where to end
* When to commit and when to rollback

* Declarative and Programmatic

#### Declarative

* Specify in configuration file or use annotations
* No change in the design
* But granularity is a problem, the whole method executes in a transaction
* Checked Exceptions when thrown, txn is not rolled back automatically
* Configure **rollbackFor=** to rollback 

```java
class AccountService$EnhancerByCGLIB extends AccountService{
	private AccountService target;
	
	public void withdraw(...){
		//TransactionManager to start a txn
			target.withdraw(...)
		//TransactionManager to end a txn
	}
}
```
#### Programmatic

* Specify in your code
* Changes in the design






