package com.example.app.controller;

import java.util.List;

import com.example.app.constant.UrlConst;
import com.example.app.dto.UserInfoDto;
import com.example.app.form.UserInfoForm;
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
  public String init(@CookieValue("SESSION") String cookie, UserInfoForm form, Model model) {
    model.addAttribute("userInfoForm", form);
    model.addAttribute("cookie", cookie);

    List<UserInfoDto> userList = userService.getUsers();
    model.addAttribute("user", userList);
    return "index";
  }

  @PostMapping(value = UrlConst.TOP)
  public String userLogin(@RequestBody UserInfoForm form, Model model) {
    model.addAttribute("userInfoForm", form);
    return "index";
  }
}
