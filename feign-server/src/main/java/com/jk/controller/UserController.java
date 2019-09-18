package com.jk.controller;


import com.jk.model.LoginUser;
import com.jk.model.Tree;
import com.jk.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 19:37
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String a(){
        return "login";
    }
    @RequestMapping("LoginUser")
    public String login(HttpServletRequest request){

        //验证当前异常是什么异常
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        System.out.println(exceptionClassName+"222222222222");
            if(UnknownAccountException.class.getName().equals(exceptionClassName)|| AuthenticationException.class.getName().equals(exceptionClassName)){
                request.getSession().setAttribute("message","当前用户名不存在");
            }else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                request.getSession().setAttribute("message","密码错误");
        }
      return "login";
    }
  @RequestMapping("index")
    public String index(){
        return "index";
  }
  @RequestMapping("403")
    public String cuo(){
         return "403";
    }
    @RequestMapping("tree")
    public void tree(HttpServletRequest request){
        LoginUser login = (LoginUser) SecurityUtils.getSubject().getSession().getAttribute("login");

     List<Tree> tree=userService.tree(login.getUserid());
    }
}
