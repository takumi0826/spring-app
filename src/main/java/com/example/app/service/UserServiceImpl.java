package com.example.app.service;

import java.util.List;

import com.example.app.entity.MUser;
import com.example.app.repository.UserMapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * UserService
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  
  private final UserMapper mapper;
  
  @Override
  public void signup(MUser user) {
    mapper.insertOne(user);
  }

  @Override
  public List<MUser> getUsers() {
    return mapper.findMany();
  }

  @Override
  public MUser getUserOne(String userId) {
    return mapper.findOne(userId);
  }

  @Override
  public void updateUserOne(String userId, String password, String userName) {
    mapper.updateOne(userId, password, userName);
  }

  @Override
  public void deleteUserOne(String userId) {
    mapper.deleteOne(userId);
  };

  @Override
  public MUser getLoginUser(String userId) {
    return mapper.findLoginUser(userId);
  }

}