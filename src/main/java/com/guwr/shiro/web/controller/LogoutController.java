package com.guwr.shiro.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by   guwr
 * Project_name shiro-web
 * Path         com.guwr.shiro.web.controller.LogoutController
 * Date         2017/4/2
 * Time         13:55
 * Description
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "logout")
    public String logout() {
        System.out.println("logout");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
