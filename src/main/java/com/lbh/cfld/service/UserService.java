package com.lbh.cfld.service;

import com.lbh.cfld.domain.User;
import com.lbh.cfld.utils.Result;

public interface UserService {
    void insertUserTest(User user);
    Result userLogin(User user);
    int userRegister(User user);
}
