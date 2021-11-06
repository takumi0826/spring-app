package com.example.app.service;

import java.util.List;

import com.example.app.dto.UserInfoDto;

import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public interface UserService {

  void signup(UserInfoDto user);

  List<UserInfoDto> getUsers();

  UserInfoDto getUserOne(String userId);

  void updateUserOne(String userId, String password, String userName);

  void deleteUserOne(String userId);

  UserInfoDto getLoginUser(String userId);
}