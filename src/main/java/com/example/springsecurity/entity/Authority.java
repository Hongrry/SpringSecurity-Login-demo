package com.example.springsecurity.entity;

/**
 * @author Hongrry
 * @create 2021-08-23 20:18
 */
public class Authority {
    private String username;
    private String authority;

    public Authority() {

    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
