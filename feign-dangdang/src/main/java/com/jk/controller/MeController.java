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
import com.jk.model.Take;
import com.jk.service.MeService;
import com.jk.util.CheckImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    //跳vipMy注html页面
    @RequestMapping("/tovipMy")
    public String tovipMy(){

        return "vipMy";
    }
    //跳转修改会员密码页面
    @RequestMapping("/tovipPwd")
    public String tovipPwd(){

        return "vipPwd";
    }
    //跳转vipExit.html页面
    @RequestMapping("tovipExit")
    public String tovipExit(){

        return "vipExit";
    }
    //跳转vipTuihuo.html页面
    @RequestMapping("tovipTuihuo")
    public String tovipTuihuo(){

    return "vipTuihuo";
    }
    //前台会员登录
    @RequestMapping("memberLogin2")
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
    public String savemeMberUser(MemberUser memberUser, HttpSession session, HttpServletRequest  request, String checkcode){
        String attribute = (String) request.getSession().getAttribute("checkcode");
        System.out.println("验证码"+attribute);
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

    //前台个人信息查询
    @RequestMapping("queryMemberUserList")
    public String queryMemberUserList(Model model){
        List<Member> list = meService.queryMemberUserList();
        Member user = list.get(0);
        model.addAttribute("user",user);
        return "vipMy";
    }
    //密码修改
    @RequestMapping("updatePassword")
    @ResponseBody
    public void updatePassword(Member member){
        meService.updatePassword(member);
    }
    //密码修改返回页面
    @RequestMapping("queryUpdateMemberList")
    public String queryUpdateMemberList(Model model){
        List<Member> list = meService.queryUpdateMemberList();
        Member user = list.get(0);
        model.addAttribute("user",user);
        return "vipPwd";
    }
    //验证码
    @RequestMapping("checkImg")
    public void checkImg(HttpServletRequest   request  ,HttpServletResponse  response){


        CheckImgUtil.buildCheckImg(request, response);
    }
    //收货地址列表查询
    @RequestMapping("queryTakeAreaList")
    public String queryTakeAreaList(Model model){
        List<Take> list = meService.queryTakeAreaList();
        Take take = list.get(0);
        model.addAttribute("take",take);
        return "vipAdress";
    }
    //前台添加收货地址
    @RequestMapping("saveShuoHuoArea")
    @ResponseBody
    public void saveShuoHuoArea(Take take){
        meService.saveShuoHuoArea(take);
    }
    //前台修改收货地址
    @RequestMapping("updateShuoHouArea")
    @ResponseBody
    public void updateShuoHouArea(Take take){
        meService.updateShuoHouArea(take);
    }





}
