# Spring Boot Workspace

## The Basics

### Databases

1. JDBC - jdbc-proof-of-concept

- inserts a student into the students table
- Spring Boot dependencies: jdbc & postgresql

2. Java Persistence API - jpa-proof-of-concept

- inserts a student into the students table
- Spring Boot dependencies: jpa & postgresql

### RESTful Services

1. REST - rest-proof-of-concept

- static response ("Hello, world!") from /message endpoint
- dynamic response from /echo endpoint
- Spring Boot dependencies: web & security

2. REST & JPA - rest-jpa-proof-of-concept

- CRUD operations on the students table
- Spring Boot dependencies: web, security, jpa, & postgresql

### User Interfaces

1. REST & React - rest-react-proof-of-concept

- static response ("Hello, world!") from /message endpoint
- dynamic response from /echo endpoint
- Spring Boot dependencies: web & security
- ./proof-of-concept-api
- ./proof-of-concept-ui

2. REST, JPA, & React

- CRUD operations on the students table from /students endpoint
- Spring Boot dependencies: web, security, jpa, & postgresql
- ./proof-of-concept-api
- ./proof-of-concept-ui

## Advanced

### Microservices

1. Service Dependence

### Data

1. GraphQL - graphql-proof-of-concept

- GraphQL facade over microservices

2. Hazelcast

### Deployment

1. Containerization
