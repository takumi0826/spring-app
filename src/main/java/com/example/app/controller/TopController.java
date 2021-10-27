package com.example.app.controller;

import com.example.app.constant.UrlConst;
import com.example.app.form.UserAuthForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TopController extends BaseController {

  @GetMapping(value = UrlConst.TOP)
  public String init(@CookieValue("SESSION") String cookie, UserAuthForm form, Model model) {
    model.addAttribute("userAuthForm", form);
    model.addAttribute("cookie", cookie);
    return "index";
  }

  @PostMapping(value = UrlConst.TOP)
  public String userLogin(@RequestBody UserAuthForm form, Model model) {
    model.addAttribute("userAuthForm", form);
    return "index";
  }
}
