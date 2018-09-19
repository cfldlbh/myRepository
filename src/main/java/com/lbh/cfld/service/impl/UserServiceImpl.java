package com.lbh.cfld.service.impl;

import com.lbh.cfld.dao.UserMapper;
import com.lbh.cfld.domain.User;
import com.lbh.cfld.service.UserService;
import com.lbh.cfld.utils.Result;
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
    @Override
    public void insertUserTest(User user){
        userMapper.insert(user);
    }

    @Override
    public Result userLogin(User user) {
        User select = userMapper.selectByLoginName(user.getLoginname());
        if(select!=null&&select.getPassword().equals(user.getPassword())){
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes servletRequest = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = servletRequest.getRequest();
            request.setAttribute("user",select);
            return new Result(true,"登录成功！");
        }
        return new Result(false,"密码不正确或者用户不存在！");
    }

    @Override
    public int userRegister(User user) {
        return userMapper.insert(user);
    }
}
