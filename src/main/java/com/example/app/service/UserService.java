package com.example.app.service;

import java.util.List;

import com.example.app.entity.MUser;

import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public interface UserService {

  List<MUser> findMany();
} 