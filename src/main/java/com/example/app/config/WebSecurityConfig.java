package com.example.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  /** セキュリティの各種設定 */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ログイン不要ページの設定
    http.authorizeRequests()
        .antMatchers("/login") // 直リンクOK
        .permitAll().antMatchers("/user/signup").permitAll() // 直リンクOK
        .anyRequest().authenticated(); // それ以外直リンクNG

    // ログイン処理
    http.formLogin().loginProcessingUrl("/login") //　ログイン処理のパス
        .loginPage("/login").failureUrl("/login?error") //　ログイン失敗時の遷移先
        .usernameParameter("userId") //ログインページのユーザーID
        .passwordParameter("password") // ログインページのパスワード
        .defaultSuccessUrl("/user/list", true); // ログイン成功後の遷移先

    //　ログアウト処理
    http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutUrl("/logout") //ログアウト画面のURL
        .logoutSuccessUrl("/login?logout"); // ログアウト成功後の遷移先

    // CSRF対策
    http.csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.debug(false).ignoring().antMatchers("/images/**", "/js/**", "/css/**");
  }
}
