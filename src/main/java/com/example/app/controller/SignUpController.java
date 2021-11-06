package com.example.app.controller;

import com.example.app.dto.UserInfoDto;
import com.example.app.form.UserInfoForm;
import com.example.app.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignUpController {

  private final UserService userService;

  private final ModelMapper modelMapper;

  @GetMapping(value="/user/signup")
  public String init(UserInfoForm form, Model model) {
    model.addAttribute("userInfoForm", form);
    return "user/signup";
  }

  @PostMapping(value="/user/signup")
  public String signUp(@Validated UserInfoForm form, BindingResult error, Model model) {
    if(error.hasErrors()){
      return "/user/signup";
    }

    UserInfoDto dto = modelMapper.map(form, UserInfoDto.class);
    userService.signup(dto);
    return "/login";
  }
}
