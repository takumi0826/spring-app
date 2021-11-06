package com.example.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfoDto {

  private String userId;

  private String password;

  private String userName;

  private Date birthday;

  private Integer age;

  private Integer gender;

  private Integer departmentId;

  private String role;
}
