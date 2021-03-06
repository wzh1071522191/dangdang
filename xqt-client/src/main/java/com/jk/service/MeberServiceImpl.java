/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: MeberServiceImpl
 * Author:   薛琪陶
 * Date:     2019/9/18 0018 11:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.mapper.MeberMapper;
import com.jk.model.LoginUser;
import com.jk.model.Member;
import com.jk.model.MemberUser;
import com.jk.model.Take;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class MeberServiceImpl implements MeberServiceApi{

    @Autowired
    private MeberMapper meberMapper;
//分页查询会员列表
    @Override
    public HashMap<String, Object> queryMeberAll(Integer page, Integer rows, Member member) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("member", member);
        int count = meberMapper.findMemberCount(hashMap);
        List<Member> lists = meberMapper.findMemberList((page-1)*rows,rows,member);
        hashMap.put("total", count);
        hashMap.put("rows", lists);
        return hashMap;
    }
    //批量删除会员数据
    @Override
    public void deleteMemberAll(Integer[] ids) {
        meberMapper.deleteMemberAll(ids);
    }
    //单删会员信息
    @Override
    public void deleteMember(Integer[] ids) {
        meberMapper.deleteMember(ids);
    }
    //新增会员信息
    @Override
    public void saveMember(Member member) {
         meberMapper.saveMember(member);
    }
    //修改会员信息
    @Override
    public void updateMeber(Member member) {
        meberMapper.updateMeber(member);
    }
    //回显会员信息
    @Override
    public Member queryFindMemberById(Integer id) {
        return meberMapper.queryFindMemberById(id);
    }

    //前台登录会员
    @Override
    public MemberUser queryUserName(String username) {
        MemberUser st=meberMapper.queryUserName(username);
        return st;
    }
    //前台注册会员
    @Override
    public String savemeMberUser(MemberUser memberUser) {
        if(!memberUser.getUsername().equals("")){
            meberMapper.savemeMberUser(memberUser);
        }
        return "1";
    }
    //前台会员列表展示
    @Override
    public List<Member> queryMemberList() {
        return meberMapper.queryMemberList();
    }
    //前台会员信息修改
    @Override
    public void updateMemberUser(Member member) {
        meberMapper.updateMemberUser(member);
    }
    //前台会员个人信息展示
    @Override
    public List<Member> queryMemberUserList() {
        return meberMapper.queryMemberUserList();
    }
    //前台密码修改
    @Override
    public void updatePassword(Member member) {
        meberMapper.updatePassword(member);
    }
    //密码修改返回页面
    @Override
    public List<Member> queryUpdateMemberList() {
        return meberMapper.queryUpdateMemberList();
    }
    //收货地址列表查询
    @Override
    public List<Take> queryTakeAreaList() {
        return meberMapper.queryTakeAreaList();
    }
    //前台添加收货地址
    @Override
    public void saveShuoHuoArea(Take take) {
        meberMapper.saveShuoHuoArea(take);
    }
    //前台修改收货地址
    @Override
    public void updateShuoHouArea(Take take) {
        meberMapper.updateShuoHouArea(take);
    }


}
