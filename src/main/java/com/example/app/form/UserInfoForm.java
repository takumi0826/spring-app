package com.example.app.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserInfoForm {

  @NotBlank
  private String userId;

  @NotBlank
  private String password;

  // @NotBlank
  private String userName;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;

  @NotNull
  private Integer age;

  @NotNull
  private Integer gender;

  private Integer departmentId;

  private String role;
}
