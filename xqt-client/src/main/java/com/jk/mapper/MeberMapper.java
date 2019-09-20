package com.jk.mapper;

import com.jk.model.LoginUser;
import com.jk.model.Member;
import com.jk.model.MemberUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface MeberMapper {
    //分页查询会员列表
    int findMemberCount(HashMap<String, Object> hashMap);

    List<Member> findMemberList(@Param("page") int i, @Param("rows") Integer rows, @Param("member") Member member);
    //批量删除会员数据
    void deleteMemberAll(Integer[] ids);
    //单删会员信息
    void deleteMember(Integer[] ids);
    //新增会员信息
    String saveMember(Member member);
    //修改会员信息
    void updateMeber(Member member);
    //回显会员信息
    Member queryFindMemberById(Integer id);
    //前台登录会员
    @Select("select * from user u where u.username=#{username}")
    MemberUser queryUserName(String username);
    //前台注册会员
    @Insert("insert into user(username,password,userphone,jifen,dengji,status) values(#{username},#{password},#{userphone},0,1,1)")
    void savemeMberUser(MemberUser memberUser);
    //前台列表查询
    List<Member> queryMemberList();

    void updateMemberUser(Member member);

}
