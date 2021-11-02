package com.example.app.repository;

import java.util.List;

import com.example.app.entity.MUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  public int insertOne(MUser user);

  public List<MUser> findMany();

  public MUser findOne(String userId);

  public void updateOne(@Param("userId") String userId, @Param("password") String password, @Param("userName") String userName);

  public void deleteOne(@Param("userId") String userId);

  public MUser findLoginUser(String userId);
}
