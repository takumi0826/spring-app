package com.example.app.controller;

import com.example.app.constant.UrlConst;
import com.example.app.dto.UserInfoDto;
import com.example.app.form.SignupForm;
import com.example.app.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SignupController {

  private final UserService userService;

  private final ModelMapper modelMapper;

  @GetMapping(value = UrlConst.SIGNUP)
  public String init(SignupForm form, Model model) {
    model.addAttribute("signupForm", form);
    return "/user/signup";
  }

  @PostMapping(value = UrlConst.SIGNUP)
  public String signUp(@Validated SignupForm form, BindingResult error, Model model) {
    log.info(form.toString());
    if(error.hasErrors()){
      return "/user/signup";
    }

    UserInfoDto dto = modelMapper.map(form, UserInfoDto.class);
    userService.signup(dto);
    return "redirect:/login";
  }
}
