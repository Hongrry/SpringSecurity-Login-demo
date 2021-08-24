package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hongrry
 * @create 2021-08-23 17:01
 */
@Controller
public class RouterController {
    @Autowired
    UserService service;

    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/doRegister")
    public String doRegister(User user) {
        if (service.insertUser(user)) {
            return "redirect:/toLogin";
        } else {
            return "redirect:/toRegister";
        }
    }

    @RequestMapping("/vip1")
    @ResponseBody
    public String toVIP1() {
        return "有权访问 VIP1";
    }

    @RequestMapping("/vip2")
    @ResponseBody
    public String toVIP2() {
        return "有权访问 VIP2";
    }

    @RequestMapping("/vip3")
    @ResponseBody
    public String toVIP3() {
        return "有权访问 VIP3";
    }

}
