package com.example.app.controller;

import com.example.app.constant.UrlConst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
  @GetMapping(value = UrlConst.LOGIN)
  public String init() {
    return "login";
  }
}
