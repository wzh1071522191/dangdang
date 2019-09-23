package com.jk.controller;


import com.jk.model.Comments;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 19:37
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("comment")
public class UserController {

    @Autowired
    private UserService userService;
   //前台查询评论的方法
    @RequestMapping("pinglun")
    public String pinglun(HttpServletRequest request){
        List<Comments> list=userService.pinglun();
        request.getSession().setAttribute("list",list);
        return "proinfo";
    }
}
