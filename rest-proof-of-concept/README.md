# Spring Boot JPA Connectivity Proof of Concept

Basic Spring Boot RESTful API. Resources & tutorials used:

- [Building a RESTful Web Service][1]

## Steps to reproduce

1. Ensure prerequisites are installed and configured:

- Java JDK version 17 (OpenJDK is fine)
- Spring CLI version 3.1.1

2. Create the project

```bash
  spring init -dweb --build maven --packaging jar --extract rest-proof-of-concept
```

3. Remove the DemoApplication source code

- src/main/java/com/example/demo/DemoApplication.java
- src/test/java/com/example/demo/DemoApplicationTests.java

4. Add source code based on [Building a RESTful Web Service][1]

- ProofOfConceptApplication.java
- ProofOfConceptController.java
- Greeting.java

5. Configure application via "src/main/resources/application.properties"

- server.port=8000

6. Compile, package, and run the application

```bash
  mvn package
  java -jar target/rest-proof-of-concept-0.0.1-SNAPSHOT.jar
```

7. Open localhost:8000/message to see the greeting "Hello, world!"

   [1]: https://spring.io/guides/gs/rest-service/
