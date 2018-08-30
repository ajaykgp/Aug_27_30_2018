#### Enabling Hystrix Dashboard


* Add the dependency to pom.xml

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
	<version>2.0.1.RELEASE</version>
</dependency>
```
* In **PalindromeClientServiceApplication.java** add **@EnableHystrixDashboard** annotation
* In **application.properties** add the following line

```
management.server.port=8081
```

* Open **http:localhost:7000/hystrix** in the browser
* In the textbox to enter a stream enter **http://localhost:8081/actuator/hystrix.stream**


* Now, access your palindrome client service from a different browser tab. Bring your palindrome service up and down and access the client service

* Monitor the dashboard



