package com.example.app.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

  @NotBlank(message = "{NotBlank}")
  private String userId;

  @NotBlank(message = "{NotBlank}")
  private String password;

  @NotBlank(message = "{NotBlank}")
  private String userName;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;

  @NotNull(message = "{NotNull}")
  private Integer age;

  @NotNull(message = "{NotNull}")
  private Integer gender;
}
