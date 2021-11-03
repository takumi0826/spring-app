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
  public List<MUser> findMany() {
    return mapper.findMany();
  };
}