# Spring Boot JPA Connectivity Proof of Concept

## Steps to reproduce

1. Ensure prerequisites are installed and configured:

- Java JDK version 17 (OpenJDK is fine)
- Spring CLI version 3.1.1
- PostgreSQL server is running

2. Create the project

```bash
  spring init -djpa,postgresql --build maven --packaging jar --extract jpa-proof-of-concept
```

_NOTE_: whatever is specified after `--extract` will be the directory that is created for the project as well as the artifactId of the project. Specifying nothing will use the current directory and the artifactId will be "demo"

_NOTE_: spring will add the following dependency in `pom.xml` which is not needed:

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
```

3. Remove the DemoApplication source code

- src/main/java/com/example/demo/DemoApplication.java
- src/test/java/com/example/demo/DemoApplicationTests.java

4. Add source code from step 4 of [this tutorial][1]

- src/main/java/com/example/SpringJpaApplication.java
- src/main/java/com/example/StudentRepository.java
- src/main/java/com/example/Student.java

_NOTE_: the source code inserts a row into the `students` table with values for "full_name", "last_name", and "email"

5. Configure the database connection according to steps 2 & 4 of [this tutorial][1]

- src/main/resources/application.properties

_NOTE_: the database configuration currently expects to connect to the `spring-boot-workspace` database with password authenticated user 'postgres'
_NOTE_: the dialect specified in the tutorial is "PostgreSQL81Dialect" but that doesn't work with Postgres 14, so use "PostgreSQLDialect"

6. Compile, package, and run the application

```bash
  mvn package
  java -jar target/jpa-proof-of-concept-0.0.1-SNAPSHOT.jar
```

_NOTE_: the artifact from step 6 corresponds to the project artifactId specified in `pom.xml`,

so if pom.xml is configured

```xml
  <artifactId>something-besides-jpa-proof-of-concept</artifactId>
```

will produce the artifact `target/something-besides-jpa-proof-of-concept-0.0.1-SNAPSHOT.jar`. And, if nothing was specified after `--extract` from step 2 (see the NOTE), then the artifact will be `target/demo-0.0.1-SNAPSHOT.jar`

7. Observe that the students table in the spring-boot-workspace database has a new row with the values determined by the application source code

[1]: https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples
