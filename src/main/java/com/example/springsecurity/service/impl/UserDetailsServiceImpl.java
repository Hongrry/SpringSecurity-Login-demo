package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.Authority;
import com.example.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Hongrry
 * @create 2021-08-23 18:47
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.queryUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        Set<GrantedAuthority> authority = getAuthority(user.getUsername());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authority);
    }

    private Set<GrantedAuthority> getAuthority(String username) {
        Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<>();
        LinkedList<Authority> list = userService.queryUserAuthorityByName(username);
        list.forEach(item ->
                grantedAuthorities.add(new SimpleGrantedAuthority(item.getAuthority()))
        );

        return grantedAuthorities;
    }
}
