package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

  @GetMapping(value="/user/signup")
  public String signUp() {
      return "user/signup";
  }
}
