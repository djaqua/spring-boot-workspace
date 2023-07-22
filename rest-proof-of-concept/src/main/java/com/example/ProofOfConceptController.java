package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// NOTE: this is distinctly different from org.springframework.stereotype.Controller
@RestController
public class ProofOfConceptController {

  @RequestMapping(value = "/message", method = RequestMethod.GET)
  public Greeting getMessage() {
    // NOTE: could just as well return a POJO (as opposed to a record)
    return new Greeting("Hello, world!");
  }
}
