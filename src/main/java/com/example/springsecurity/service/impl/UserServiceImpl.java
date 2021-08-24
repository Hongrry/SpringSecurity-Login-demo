package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.Authority;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * @author Hongrry
 * @create 2021-08-23 19:02
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public boolean insertUser(User user) {
        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 默认有 VIP1 的权限
        Authority role_vip1 = new Authority(user.getUsername(), "ROLE_VIP1");
        return userMapper.insertUser(user) && insertAuthority(role_vip1);
    }

    @Override
    public boolean insertAuthority(Authority authority) {
        return userMapper.insertAuthority(authority);
    }

    @Override
    public LinkedList<Authority> queryUserAuthorityByName(String username) {
        return userMapper.queryUserAuthorityByName(username);
    }
}
