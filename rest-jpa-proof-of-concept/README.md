# Spring Boot JPA Connectivity Proof of Concept

## Objective

Combine the JPA proof of concept with the RESTful API proof of concept.
Resources & Tutorials used:

- [Spring Boot Connect to PostgreSQL Database Examples][1]
- [Building REST Services with Spring][2]
- [Security Spring Boot API Key and Secret][3]
- [HttpSecurity JavaDoc][4]

## Steps to reproduce

1. Ensure prerequisites are installed and configured:

- Java JDK version 17 (OpenJDK is fine)
- Spring CLI version 3.1.1
- PostgreSQL server is running

2. Create the project

```bash
  spring init -dweb,security,jpa,postgresql --build maven --packaging jar --extract rest-jpa-proof-of-concept
```

3. Remove the DemoApplication source code

- src/main/java/com/example/demo/DemoApplication.java
- src/test/java/com/example/demo/DemoApplicationTests.java

4. Add the proof of concept entry point

- ProofOfConceptApplication.java

_NOTE:_ disable the security auto-configuration as described in [Security Spring Boot API Key and Secret][3]

4. Add source code from step 4 of [Spring Boot Connect to PostgreSQL Database Examples][1]

- StudentRepository.java
- Student.java

5. Add source code based on the "HTTP is the Platform" section of [Building REST Services with Spring][2]

- StudentNotFoundException.java
- StudentNotFoundAdvice.java
- StudentRestController.java

5. Add the authentication source code from [Security Spring Boot API Key and Secret][3]

- ApiKeyAuthentication.java
- AuthenticationService.java
- AuthenticationFilter.java
- SecurityConfig.java

_NOTE:_ the version of HttpSecurity in the Baeldung tutorial is outdated, so the [HttpSecurity JavaDoc][4] provides some hints:

```java
  // from the Baeldung SecurityConfig.filterChain implementation
  http.csrf()
    .disable()
    .authorizeRequests()
    .antMatchers("/**")
    .authenticated()
    .and()
    .httpBasic()
    .and()
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
```

```java
  // implementation of SecurityConfig.filterChain based on the Spring Boot HttpSecurity JavaDoc
  httpSec.csrf((csrf) -> csrf.disable())
    .authorizeHttpRequests((authReq) -> authReq.anyRequest().authenticated())
    .sessionManagement((sessiongMgmt) -> sessiongMgmt.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
```

6. Configure the database connection according to steps 2 & 4 of [Spring Boot Connect to PostgreSQL Database Examples][1]

- src/main/resources/application.properties

7. Configure application via "src/main/resources/application.properties"

- database configuration (e.g. sections 2 & 4 of [Spring Boot Connect to PostgreSQL Database Examples][1])
- server.port=8000

7. Compile, package, and run the application

```bash
  mvn package
  java -jar target/rest-jpa-proof-of-concept-0.0.1-SNAPSHOT.jar
```

8. Observe that the students table in the spring-boot-workspace database has a new row with the values determined by the application source code

[1]: https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples
[2]: https://spring.io/guides/tutorials/rest/
[3]: https://www.baeldung.com/spring-boot-api-key-secret
[4]: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
