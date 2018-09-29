package com.lbh.cfld.shiroRealm;/*
 */

import com.lbh.cfld.dao.RoleUserMapper;
import com.lbh.cfld.dao.UserMapper;
import com.lbh.cfld.domain.Role;
import com.lbh.cfld.domain.RoleUser;
import com.lbh.cfld.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleUserMapper roleUserMapper;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User primaryPrincipal = (User)principals.getPrimaryPrincipal();
        ArrayList<String> roles = roleUserMapper.selectUserRoleByUid(primaryPrincipal.getUserid());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(roles);
        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        User user = userMapper.selectByLoginName(token1.getUsername());
        if(user==null){
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getLoginname(), user.getPassword(), getName());
        return simpleAuthenticationInfo;
    }
}
