package com.guwr.shiro.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by   guwr
 * Project_name shiro-web
 * Path         com.guwr.shiro.web.controller.LoginController
 * Date         2017/4/2
 * Time         13:55
 * Description
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        System.out.println("login get");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password) {
        System.out.println("login post");
        Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        if (!authenticated) {
            System.out.println("没有登录");
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            if (!subject.hasRole("admin")) {
                System.out.println("没有权限 admin= " + username);
            } else {
                System.out.println("admin");
            }
            if (!subject.hasRole("user")) {
                System.out.println("没有权限 user= " + username);
            } else {
                System.out.println("user");
            }
        }
        System.out.println("subject = " + subject);
        return "redirect:/index.jsp";
    }
}
