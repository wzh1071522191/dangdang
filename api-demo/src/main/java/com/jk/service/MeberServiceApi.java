package com.jk.service;

import com.jk.model.LoginUser;
import com.jk.model.Member;
import com.jk.model.MemberUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 会员信息接口--xqt
 * 2019-9-17
 */

public interface MeberServiceApi {
    //用户详细信息分页查询
    @RequestMapping(value = "/queryMeberAll")
    HashMap<String, Object> queryMeberAll(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestBody Member member);
    //批量删除会员信息
    @RequestMapping(value = "/deleteMemberAll")
    void deleteMemberAll(@RequestParam("ids") Integer[] ids);
    //单删会员信息
    @RequestMapping(value = "/deleteMember")
    void deleteMember(@RequestParam("ids") Integer[] ids);
    //新增会员信息
    @RequestMapping(value = "/saveMember")
    void saveMember(@RequestBody Member member);
    //修改会员信息
    @RequestMapping(value = "/updateMeber")
    void updateMeber(@RequestBody Member member);
    //回显会员信息
    @RequestMapping(value = "/queryFindMemberById")
    Member queryFindMemberById(@RequestParam("id") Integer id);
    //前台会员登录
    @RequestMapping(value = "/queryUserName")
    MemberUser queryUserName(@RequestParam("username")  String username);
    //前台会员注册
    @RequestMapping(value = "/savemeMberUser")
    String savemeMberUser(@RequestBody MemberUser memberUser);

}
