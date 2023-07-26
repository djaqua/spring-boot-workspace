# Spring Boot JDBC Connectivity Proof of Concept

## Objective

Basic database connectivity for Spring Boot. Inserts a record into the `students` table of the `spring-boot-workspace` database.
Resources & Tutorials used:

- [Spring Boot Connect to PostgreSQL Database Examples][1]

## Steps to reproduce

1. Ensure prerequisites are installed and configured:

- Java JDK version 17 (OpenJDK is fine)
- Spring CLI version 3.1.1
- PostgreSQL server is running

2. Create the project

```bash
  spring init -djdbc,postgresql --build maven --packaging jar --extract jdbc-proof-of-concept
```

3. Remove the DemoApplication source code

- src/main/java/com/example/demo/DemoApplication.java
- src/test/java/com/example/demo/DemoApplicationTests.java

4. Add source code based on section 3 of [Spring Boot Connect to PostgreSQL Database Examples][1]

- ProofOfConceptApplication.java

5. Configure application via "src/main/resources/application.properties"

- database configuration (e.g. section 2 of [Spring Boot Connect to PostgreSQL Database Examples][1])

6. Compile, package, and run the application

```bash
  mvn package
  java -jar target/jdbc-proof-of-concept-0.0.1-SNAPSHOT.jar
```

7. Observe that the students table in the spring-boot-workspace database has a new row with the values determined by the application source code

[1]: https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples
