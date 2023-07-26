package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProofOfConceptApplication implements CommandLineRunner {

  @Autowired
  StudentRepository studentRepo;

  public static void main(String[] args) {
    SpringApplication.run(ProofOfConceptApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Student s = new Student();
    s.setFirstName("Skipper");
    s.setLastName("Thompson");
    s.setEmail("skipper.thompson@example.com");
    studentRepo.save(s);
  }
}