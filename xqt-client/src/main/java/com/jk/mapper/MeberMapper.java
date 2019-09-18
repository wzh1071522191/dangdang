package com.jk.mapper;

import com.jk.model.Member;
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
}
