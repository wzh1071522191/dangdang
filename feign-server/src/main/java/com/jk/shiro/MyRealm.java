/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MyRealm
 * Author:   zyl
 * Date:     2018/12/26 13:56
 * Description: test
 * History:
 */
package com.jk.shiro;


import com.jk.model.LoginUser;

import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author zyl
 * @create 2018/12/26
 * @since 1.0.0
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取主身份信息
       // String user = (String) principals.getPrimaryPrincipal();
      /* User user = (User) SecurityUtils.getSubject().getSession().getAttribute("login");

        List<QuanXian> quanXian=se.tree(user.getId());
        //根据身份信息获取权限信息
        //模拟从数据库获取到数据

        List<String> permissions = new ArrayList<String>();
        for (QuanXian a:quanXian) {
            permissions.add(a.getPerssion());
        }
*/
        //将查询到授权信息填充到对象中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
      //  info.addStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.从token取出用户身份信息
        String username = (String)token.getPrincipal();

        LoginUser user=userService.loginUser(username);


        //查询数据库 判断当前user是否为空
      /*  User user = userServcice.queryUserByName(username);*/
        //如果查询不到则返回null  user==null
        if(user==null){//这里模拟查询不到
            throw new UnknownAccountException();
        }else{
            String password = user.getPassword();

            //2.根据用户userCode查询数据库

        //模拟从数据库查询到的密码


        //查询到返回认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,this.getName());
        SecurityUtils.getSubject().getSession().setAttribute("login",user);
        return authenticationInfo;

    }
    }
}
