package com.example.app.controller;

import java.util.List;

import com.example.app.constant.UrlConst;
import com.example.app.entity.MUser;
import com.example.app.form.UserAuthForm;
import com.example.app.service.UserService;

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

  private final UserService userService;

  @GetMapping(value = UrlConst.TOP)
  public String init(@CookieValue("SESSION") String cookie, UserAuthForm form, Model model) {
    model.addAttribute("userAuthForm", form);
    model.addAttribute("cookie", cookie);

    List<MUser> userList = userService.findMany();
    model.addAttribute("user", userList);
    return "index";
  }

  @PostMapping(value = UrlConst.TOP)
  public String userLogin(@RequestBody UserAuthForm form, Model model) {
    model.addAttribute("userAuthForm", form);
    return "index";
  }
}
