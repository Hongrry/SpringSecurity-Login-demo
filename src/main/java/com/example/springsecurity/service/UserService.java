package com.example.springsecurity.service;

import com.example.springsecurity.entity.Authority;
import com.example.springsecurity.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Hongrry
 * @create 2021-08-23 19:02
 */
public interface UserService {
    User queryUserByName(String username);

    boolean insertUser(User user);

    boolean insertAuthority(Authority authority);

    LinkedList<Authority> queryUserAuthorityByName(String username);
}
