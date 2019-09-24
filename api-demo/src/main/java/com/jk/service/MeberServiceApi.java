package com.jk.service;

import com.jk.model.Member;
import com.jk.model.MemberUser;
import com.jk.model.Take;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;

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
    //前台会员列表展示
    @RequestMapping(value = "/queryMemberList")
    List<Member> queryMemberList();
    //前台会员信息修改
    @RequestMapping(value = "/updateMemberUser")
    void updateMemberUser(@RequestBody  Member member);
    //前台会员个人信息
    @RequestMapping(value = "/queryMemberUserList")
    List<Member> queryMemberUserList();
    //前台密码修改
    @RequestMapping(value = "/updatePassword")
    void updatePassword(@RequestBody Member member);
    //密码修改返回页面
    @RequestMapping(value = "/queryUpdateMemberList")
    List<Member> queryUpdateMemberList();
    //收货地址列表查询
    @RequestMapping(value = "/queryTakeAreaList")
    List<Take> queryTakeAreaList();
    //前台添加收货地址
    @RequestMapping(value = "/saveShuoHuoArea")
    void saveShuoHuoArea(@RequestBody Take take);
    //前台修改收货地址
    @RequestMapping(value = "/updateShuoHouArea")
    void updateShuoHouArea(@RequestBody Take take);

}
