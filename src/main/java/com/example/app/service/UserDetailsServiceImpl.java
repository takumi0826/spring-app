package com.example.app.service;

import java.util.ArrayList;
import java.util.List;

import com.example.app.dto.UserInfoDto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * UserDetailsServiceImpl
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

  private final UserService service;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserInfoDto loginUser = service.getLoginUser(username);

    if (loginUser == null) {
      throw new UsernameNotFoundException("ユーザーが見つからないよ");
    }

    // 権限List作成
    GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getRole());
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(authority);

    // UserDetails生成
    UserDetails userDetails = (UserDetails) new User(loginUser.getUserId(), loginUser.getPassword(), authorities);

    return userDetails;
  }

}