#### Some points

```java
class Account{
	accountNumber,balance
	deposit(amount){ ... }
	withdraw(amount){ ... }
	transferFund(to,amount){ ... }
}
```
* Object Pooling -> Pool of Account objects
* Transaction service for transferFund method
* Security functionality for withdraw and transferFund

### EJB

* Container

```java
interface AccountHome{
	...
}
interface AccountRemote{
	accountNumber,balance
	deposit(amount){ ... }
	withdraw(amount){ ... }
	transferFund(to,amount){ ... }
}
class AccountBean implements EntityBean{
	accountNumber,balance
	deposit(amount){ ... }
	withdraw(amount){ ... }
	transferFund(to,amount){ ... }
}
//ejb.jar.xml
```

* No constructors
* No final methods
* No static methods
* Don't unneccessarily extend other classes
* Don't use threads
* No private methods

### Spring

* Lightweight container
* Enormous API
* Dependency Injection
* number of configuration files / annotations
* raw java -> Spring -> Spring Boot





















