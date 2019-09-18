package com.jk.controller;

import com.jk.model.LoginUser;
import com.jk.service.UserService;
import com.jk.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("LoginUser")
    public String LoginUser(LoginUser loginUser, HttpServletRequest request){
        LoginUser user=userService.loginUser(loginUser.getUsername());
        if (user.getUsername() == ""){
            return "yonghu";
        }else if(!user.getPassword().equals(loginUser.getPassword())) {
            return "mima";
        }
        request.getSession().setAttribute("user",user);
        return "ok";
    }
}
