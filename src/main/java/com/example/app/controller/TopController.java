package com.example.app.controller;

import javax.servlet.http.HttpSession;

import com.example.app.constant.UrlConst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TopController extends BaseController {

  
  @GetMapping(value=UrlConst.TOP)
  public String init(HttpSession session) {
    return "index";
  }
}
