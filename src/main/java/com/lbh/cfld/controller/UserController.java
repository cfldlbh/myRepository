package com.lbh.cfld.controller;

import com.lbh.cfld.domain.User;
import com.lbh.cfld.service.UserService;
import com.lbh.cfld.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * controller测试
     */
    @RequestMapping("/test")
    public void userTest(User user){
        userService.insertUserTest(user);
    }

    /*
    url :  /user/loginValid
     */
    @RequestMapping("/loginValid")
    public String loginValida(@Valid User user, Errors errors, Model model){
        if(errors.hasErrors()){
            return "user/login";
        }
        Result result = userService.userLogin(user);
        if (result.isResultFlag()){
            return "redirect:/index.jsp";
        }else {
            model.addAttribute("loginMsg",result.getMessage());
            return "forward:/jump/user/Login";
        }
    }
    @ResponseBody
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public Result register( User user){
        int i = userService.userRegister(user);
        Result result = new Result(true,"注册成功！");
        if(i==-1){
            result.setFlag(false);
            result.setMessage("注册失败！");
        }
        return result;
    }
}
