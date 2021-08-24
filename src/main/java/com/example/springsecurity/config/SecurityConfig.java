package com.example.springsecurity.config;

import com.example.springsecurity.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author Hongrry
 * @create 2021-08-23 17:12
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //访问授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置页面访问权限
        http.authorizeRequests()
                // 根目录都可以访问
                .antMatchers("/").permitAll()
                // 需要权限才可以访问的目录
                .antMatchers("/vip1/**").hasRole("VIP1")
                .antMatchers("/vip2/**").hasRole("VIP2")
                .antMatchers("/vip3/**").hasRole("VIP3")
                .and()
                // 登陆
                .formLogin(login -> {
                    login.loginPage("/toLogin")
                            .loginProcessingUrl("/doLogin");
                })
                // 注销
                .logout().logoutSuccessUrl("/")
                .and()
                // 记住我
                .rememberMe()
                // 表单传入参数名
                .rememberMeParameter("remember")
                // cookies 名
                .rememberMeCookieName("marked")
                // cookies 有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7);
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义认证
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
