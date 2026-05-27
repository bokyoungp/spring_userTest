package org.example.usertest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

  @GetMapping("/sample")
  public String sample(){
    return "sample";
  }
}
