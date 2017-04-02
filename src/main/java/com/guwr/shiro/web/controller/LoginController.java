package com.guwr.shiro.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("login")
    public String login() {
        System.out.println("login method");
        return "index";
    }
}
