/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: MeberController
 * Author:   薛琪陶
 * Date:     2019/9/18 0018 9:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.Member;
import com.jk.service.MeberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/meber")
public class MeberController {

    @Autowired
    private MeberService meberService;

    //跳转member.html会员信息列表
    @RequestMapping("/tomeber")
    public String tomeber(){

        return "xqt/member.html";
    }
    //跳转addmember.html会员信息列表
    @RequestMapping("/toaddmember")
    public String toaddmember(){

        return "xqt/addmember.html";
    }
    //跳转udatemember.html会员信息列表
    @RequestMapping("/toupdatemember")
    public String toupdatemember(){

        return "xqt/updatemember.html";
    }
   //用户详细信息分页查询
   @RequestMapping("queryMeberAll")
   @ResponseBody
   public HashMap<String, Object> queryMeberAll(Integer page,Integer rows,Member member){


       return meberService.queryMeberAll(page,rows,member);
   }
  //批量删除会员信息
  @RequestMapping("deleteMemberAll")
  @ResponseBody
  public Boolean deleteMemberAll(Integer[] ids){
      try {
          meberService.deleteMemberAll(ids);
          return true;
      } catch (Exception e) {
          e.printStackTrace();
          return false;
      }
  }
  //单删
  @RequestMapping("deleteMember")
  @ResponseBody
  public void deleteMember(Integer[] ids) {
      meberService.deleteMember(ids);
  }

    //新增会员信息
    @RequestMapping("saveMember")
    @ResponseBody
    public void saveMember(Member member){
         meberService.saveMember(member);
    }
    //修改会员信息
    @RequestMapping("updateMeber")
    @ResponseBody
    public void updateMeber(Member member){
        meberService.updateMeber(member);
    }

    //回显会员信息
    @RequestMapping("findMemberById")
    @ResponseBody
    public Member queryFindMemberById(Integer id) {
        return meberService.queryFindMemberById(id);
    }

}
