# Spring Boot JPA Connectivity Proof of Concept

## Steps to reproduce

1. Ensure prerequisites are installed and configured:

- Java JDK version 17 (OpenJDK is fine)
- Spring CLI version 3.1.1

2. Create the project

```bash
  spring init -dweb,security --build maven --packaging jar --extract rest-proof-of-concept
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

4. Add source code

- src/main/java/com/example/RestProofOfConceptApplication.java
- src/main/java/com/example/ProofOfConceptController.java
- src/main/java/com/example/Greeting.java

5. Configure the service port in `src/main/resources/application.properties`

- server.port=8000

6. Compile, package, and run the application

```bash
  mvn package
  java -jar target/rest-proof-of-concept-0.0.1-SNAPSHOT.jar
```

_NOTE_: the artifact from step 6 corresponds to the project artifactId specified in `pom.xml`,

so if pom.xml is configured

```xml
  <artifactId>something-besides-rest-proof-of-concept</artifactId>
```

will produce the artifact `target/something-besides-rest-proof-of-concept-0.0.1-SNAPSHOT.jar`. And, if nothing was specified after `--extract` from step 2 (see the NOTE), then the artifact will be `target/demo-0.0.1-SNAPSHOT.jar`

7. Open localhost:8000/message in a browser and login

username: "user"
password: provided in the Spring Boot console output
