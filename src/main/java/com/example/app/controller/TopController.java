package com.example.app.controller;

import java.util.Optional;

import com.example.app.constant.UrlConst;
import com.example.app.dto.UserInfoDto;
import com.example.app.form.SignupForm;
import com.example.app.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TopController extends BaseController {

  private final UserService userService;

  @GetMapping(value = UrlConst.TOP)
  public String init(@CookieValue("SESSION") String cookie, SignupForm form, Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userId = auth.getName();
    Optional<UserInfoDto> optional = userService.getUserOne(userId);
    String userName = optional.map(UserInfoDto::getUserName).orElse("hoge");
    model.addAttribute("userName", userName);
    model.addAttribute("cookie", cookie);
    return "index";
  }

  @PostMapping(value = UrlConst.TOP)
  public String userLogin(SignupForm form, Model model) {
    model.addAttribute("signupForm", form);
    return "index";
  }
}
