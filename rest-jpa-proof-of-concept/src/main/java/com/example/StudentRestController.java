package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// NOTE: this is distinctly different from org.springframework.stereotype.Controller
@RestController
public class StudentRestController {

  @Autowired
  StudentRepository studentRepo;

  // BREAD for the win

  @RequestMapping(value = "/students", method = RequestMethod.GET)
  public List<Student> browseStudents() {
    return studentRepo.findAll();
  }

  @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
  public Student readStudent(@PathVariable("id") Integer studentId) {
    return studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
  }

  @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
  public Student editStudent(@PathVariable("id") Integer studentId, @RequestBody Student studentValues) {

    Student existingStudent = studentRepo.findById(studentId)
        .orElseThrow(() -> new StudentNotFoundException(studentId));
    existingStudent.setFirstName(studentValues.getFirstName());
    existingStudent.setLastName(studentValues.getLastName());
    existingStudent.setEmail(studentValues.getEmail());

    return studentRepo.save(existingStudent);
  }

  @RequestMapping(value = "/students", method = RequestMethod.POST)
  public Student addStudent(@RequestBody Student student) {
    System.out.println("Creating new student?");
    return studentRepo.save(student);
  }

  @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
  public void deleteStudent(@PathVariable("id") Integer studentId) {
    studentRepo.deleteById(studentId);
  }
}
