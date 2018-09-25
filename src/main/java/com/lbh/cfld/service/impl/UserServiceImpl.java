package com.lbh.cfld.service.impl;

import com.lbh.cfld.dao.UserMapper;
import com.lbh.cfld.domain.User;
import com.lbh.cfld.service.UserService;
import com.lbh.cfld.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void insertUserTest(User user){
        userMapper.insert(user);
    }


    public Result userLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginname(), user.getPassword());
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            return new Result(false,"用户不存在");
        }catch (Exception e){
            return  new Result(false,"用户名密码不匹配");
        }
            return new Result(true,"登录成功！");
    }


    public int userRegister(User user) {
        return userMapper.insert(user);
    }
}
