package com.lbh.cfld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("jump/user")
public class UserControllerJump {
    /**
     * 用户注册
     * 访问路径 ：/user/register
     */
    @RequestMapping("/register")
    public String register(){
        return "user/regist";
    }
    @RequestMapping("/Login")
    public String jumpPageToLogin(){
        return "user/login";
    }
}
