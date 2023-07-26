# Common Notes

These are notes that are common to most if not all the proof of concept projects in this repository.

# Creating the Project

- whatever is specified after `--extract` will be the directory that is created for the project as well as the artifactId of the project. Specifying nothing will use the current directory and the artifactId will be "demo"

- spring will add the following dependency in `pom.xml` which is not needed and will cause problems if the demo source code is not removed:

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
```

# Source Code (for the Postgres-based projects)

- the source code inserts a row into the `students` table with values for `full_name`, `last_name`, and `email`
- Spring 3 JPA package is Jakarta (jakarta.persistence) and Spring 2 JPA uses JavaX (javax.persistence)

# Database configuration (for the Postgres-based projects)

- the dialect specified in the tutorial is "PostgreSQL81Dialect" but that doesn't work with Postgres 14, so use "PostgreSQLDialect"

```
spring.datasource.url=jdbc:postgresql://localhost:5432/spring-boot-workspace
spring.datasource.username=postgres
spring.datasource.password=changeme
```

## Compile, Package, and Run the Application

- the artifact from step 6 corresponds to the project artifactId specified in `pom.xml`, so the pom.xml configuration

```xml
  <artifactId>something-besides-project-proof-of-concept</artifactId>
```

will produce the artifact `target/something-besides-project-proof-of-concept-0.0.1-SNAPSHOT.jar`. And, if nothing was specified after `--extract` from "Creating the Project" (above), then the artifact will be `target/demo-0.0.1-SNAPSHOT.jar`
