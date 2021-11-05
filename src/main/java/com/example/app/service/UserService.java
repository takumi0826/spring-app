package com.example.app.service;

import java.util.List;

import com.example.app.entity.MUser;

import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public interface UserService {

  void signup(MUser user);

  List<MUser> getUsers();

  MUser getUserOne(String userId);

  void updateUserOne(String userId, String password, String userName);

  void deleteUserOne(String userId);

  MUser getLoginUser(String userId);
}