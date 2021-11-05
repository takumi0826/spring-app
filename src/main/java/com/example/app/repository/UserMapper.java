package com.example.app.repository;

import java.util.List;

import com.example.app.entity.MUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  /**
   * ユーザー登録
   * @param user
   * @return
   */
  public int insertOne(MUser user);

  /**
   * ユーザーリスト取得
   *
   * @return ユーザーリスト
   */
  public List<MUser> findMany();

  /**
   * ユーザー取得
   * @param userId
   * @return
   */
  public MUser findOne(String userId);

  /**
   * ユーザー更新
   * @param userId
   * @param password
   * @param userName
   */
  public void updateOne(@Param("userId") String userId, @Param("password") String password, @Param("userName") String userName);

  /**
   * ユーザー削除
   * @param userId
   */
  public void deleteOne(@Param("userId") String userId);

  /**
   * ログインユーザー取得
   * @param userId
   * @return
   */
  public MUser findLoginUser(String userId);
}
