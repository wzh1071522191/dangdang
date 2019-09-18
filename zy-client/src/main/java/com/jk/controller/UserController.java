package com.jk.controller;

import com.jk.dao.UserDao;
import com.jk.model.LoginUser;
import com.jk.model.Tree;
import com.jk.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 20:37
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("loginUser")
    @ResponseBody
    public LoginUser loginUser(String username){
        LoginUser user=userService.loginUser(username);
        return user;
     }
   @RequestMapping("tree")
    public List<Tree> tree(Integer userid){
        return  userService.tree(userid);
   }


}
