package com.example.springsecurity.mapper;

import com.example.springsecurity.entity.Authority;
import com.example.springsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

/**
 * @author Hongrry
 * @create 2021-08-23 13:53
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询权限
     *
     * @param username
     * @return
     */
    User queryUserByName(String username);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 添加权限
     *
     * @param authority
     * @return
     */

    boolean insertAuthority(Authority authority);

    /**
     * 查询权限
     *
     * @param username
     * @return
     */
    LinkedList<Authority> queryUserAuthorityByName(String username);
}
