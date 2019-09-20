/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: MeController
 * Author:   薛琪陶
 * Date:     2019/9/20 0020 9:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.Member;
import com.jk.model.MemberUser;
import com.jk.service.MeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/jumpMeber")
public class MeController {

    @Autowired
    private MeService meService;

    //跳转会员登录页面
    @RequestMapping("/tologin")
    public String tologin(){

        return "login";
    }
    //跳转会员注册页面
    @RequestMapping("/toreg")
    public String toreg(){

        return "reg.html";
    }
    //跳vip注html页面
    @RequestMapping("/tovip")
    public String tovip(){

        return "vip";
    }
    //前台会员登录
    @RequestMapping("memberLogin")
    @ResponseBody
    public String memberLogin(MemberUser memberUser, HttpServletRequest request) {
        MemberUser loginUser=meService.queryUserName(memberUser.getUsername());
        if(loginUser == null){

            return "1";
        }
        if(!loginUser.getPassword().equals(memberUser.getPassword())){
            return "2";
        }
        request.getSession().setAttribute("loginUser", loginUser);
        request.getSession().setAttribute("loginUsername",memberUser.getUsername());
        return "3";
    }
    //前台会员注册
    @RequestMapping("savemeMberUser")
    @ResponseBody
    public String savemeMberUser(MemberUser memberUser){

        return meService.savemeMberUser(memberUser);
    }
    //前台会员列表展示
    @RequestMapping("queryMemberList")
    public String queryMemberList(Model model){

        List<Member> list = meService.queryMemberList();
        Member user = list.get(0);
        model.addAttribute("user",user);

        return "vip";
    }
    //前台会员信息修改
    @RequestMapping("updateMemberUser")
    @ResponseBody
    public void updateMemberUser(Member member){
         meService.updateMemberUser(member);
    }


}
